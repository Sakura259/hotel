package com.manager.hotel.core.impl;

import java.util.Date;

import com.manager.hotel.common.CommonErrorCode;
import com.manager.hotel.common.CommonException;
import com.manager.hotel.core.CustomerService;
import com.manager.hotel.core.StayRecordService;
import com.manager.hotel.enums.CustomerCostStatusEnum;
import com.manager.hotel.enums.CustomerTypeEnum;
import com.manager.hotel.mapper.CustomerCostMapper;
import com.manager.hotel.mapper.RoomMapper;
import com.manager.hotel.mapper.StayRecordMapper;
import com.manager.hotel.model.CustomerCostDO;
import com.manager.hotel.model.CustomerDO;
import com.manager.hotel.model.RoomDO;
import com.manager.hotel.model.StayRecordDO;
import com.manager.hotel.vo.AddStayRecordVO;
import com.manager.hotel.vo.CustomerVO;
import com.manager.hotel.vo.PayVO;
import com.manager.hotel.vo.StayRecordVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * @author haobai
 * @description:
 * @date 2020-05-15 11:57
 */
@Slf4j
@Service
public class StayRecordServiceImpl implements StayRecordService {

    @Resource
    private StayRecordMapper stayRecordMapper;

    @Resource
    private CustomerService customerService;

    @Resource
    private RoomMapper roomMapper;

    @Resource
    private CustomerCostMapper customerCostMapper;

    @Override
    public List<StayRecordVO> list() {
        List<StayRecordDO> stayRecordDOS = stayRecordMapper.list();
        List<StayRecordVO> list = stayRecordDOS.stream().map(stayRecordDO -> {
            StayRecordVO stayRecordVO = new StayRecordVO();
            BeanUtils.copyProperties(stayRecordDO, stayRecordVO);

            List<CustomerCostDO> customerCostDOS = customerCostMapper.listByRecordId(stayRecordDO.getId());
            AtomicReference<Double> payNum = new AtomicReference<>(0.00D);
            AtomicReference<Double> notPayNum = new AtomicReference<>(0.00D);
            customerCostDOS.forEach(customerCostDO -> {
                if (Objects.equals(customerCostDO.getStatus(), CustomerCostStatusEnum.NOT_PAY.getCode())) {
                    notPayNum.updateAndGet(v -> v + customerCostDO.getCostValue() * customerCostDO.getDiscount());
                }
                if (Objects.equals(customerCostDO.getStatus(), CustomerCostStatusEnum.PAY.getCode())) {
                    payNum.updateAndGet(v -> v + payNum.get() + customerCostDO.getCostValue() * customerCostDO.getDiscount());
                }
            });
            stayRecordVO.setPayNum(payNum.get());
            stayRecordVO.setNotPayNum(notPayNum.get());
            CustomerDO customerDO = customerService.get(stayRecordDO.getCustomerId());
            CustomerVO customerVO = new CustomerVO();
            BeanUtils.copyProperties(customerDO, customerVO);
            stayRecordVO.setCustomerVO(customerVO);
            return stayRecordVO;
        }).collect(Collectors.toList());
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(AddStayRecordVO addStayRecordVO) {
        log.info("addStayRecordVO:{}", addStayRecordVO);
        check(addStayRecordVO.getRoomId(), addStayRecordVO.getReserveTime());
        // 新增客户信息
        CustomerVO customerVO = addStayRecordVO.getCustomerVO();
        log.info("customerVO:{}", customerVO);
        // 根据身份证判断用户是否住过
        Integer customerId = customerService.create(customerVO);

        CustomerDO customerDO = customerService.get(customerId);
        RoomDO roomDO = roomMapper.getByRoomId(addStayRecordVO.getRoomId());

        // 新增预定信息log.info("roomDO:{}", roomDO);
        StayRecordDO stayRecordDO = new StayRecordDO();
        stayRecordDO.setCustomerId(customerId);
        stayRecordDO.setCustomerName(customerDO.getCustomerName());
        stayRecordDO.setCustomerType(customerDO.getCustomerType());
        stayRecordDO.setRoomId(addStayRecordVO.getRoomId());
        stayRecordDO.setRoomType(roomDO.getRoomType());
        stayRecordDO.setReserveTime(addStayRecordVO.getReserveTime());
        stayRecordDO.setReserveOutTime(addStayRecordVO.getReserveOutTime());
        stayRecordDO.setCostStatus(1);
        stayRecordMapper.insertSelective(stayRecordDO);
        double day = (double) (addStayRecordVO.getReserveOutTime().getTime() - addStayRecordVO.getReserveTime().getTime()) / (24 * 60 * 60 * 1000);
        Integer recordDOId = stayRecordDO.getId();
        // 新建消费记录
        CustomerCostDO customerCostDO = new CustomerCostDO();
        customerCostDO.setRecordId(recordDOId);
        // 房费
        customerCostDO.setCostId(1);
        customerCostDO.setCostValue(roomDO.getRoomPrice() * day);
        customerCostDO.setDiscount(1.00D);
        customerCostDO.setStatus(1);
        customerCostMapper.insertSelective(customerCostDO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(AddStayRecordVO addStayRecordVO) {
        check(addStayRecordVO.getRoomId(), addStayRecordVO.getReserveTime());
        CustomerVO customerVO = addStayRecordVO.getCustomerVO();
        // 修改客人信息
        customerService.update(customerVO);
        RoomDO roomDO = roomMapper.getByRoomId(addStayRecordVO.getRoomId());
        // 修改入住信息
        StayRecordDO stayRecordDO = new StayRecordDO();
        stayRecordDO.setId(addStayRecordVO.getId());
        stayRecordDO.setCustomerId(customerVO.getId());
        stayRecordDO.setCustomerName(customerVO.getCustomerName());
        stayRecordDO.setCustomerType(customerVO.getCustomerType());
        stayRecordDO.setReserveTime(addStayRecordVO.getReserveTime());
        stayRecordDO.setRoomId(addStayRecordVO.getRoomId());
        stayRecordDO.setRoomType(roomDO.getRoomType());
        stayRecordDO.setCostStatus(1);
        stayRecordDO.setReserveOutTime(addStayRecordVO.getReserveOutTime());
        stayRecordMapper.updateByPrimaryKeySelective(stayRecordDO);
        // 修改房费信息
        double day = (double) (addStayRecordVO.getReserveOutTime().getTime() - addStayRecordVO.getReserveTime().getTime()) / (24 * 60 * 60 * 1000);
        CustomerCostDO customerCostDO = new CustomerCostDO();
        customerCostDO.setRecordId(addStayRecordVO.getId());
        // 房费
        customerCostDO.setCostId(1);
        customerCostDO.setCostValue(roomDO.getRoomPrice() * day);
        customerCostDO.setDiscount(1.00D);
        customerCostDO.setStatus(1);
        customerCostMapper.updateByPrimaryKeySelective(customerCostDO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) {
        StayRecordDO stayRecordDO = stayRecordMapper.selectByPrimaryKey(id);
        Integer customerId = stayRecordDO.getCustomerId();
        CustomerDO customerDO = customerService.get(customerId);
        // 新用户取消删除用户信息
        if (Objects.equals(customerDO.getCustomerType(), CustomerTypeEnum.NEW.getCode())) {
            customerService.delete(id);
        }
        // 删除费用记录
        customerCostMapper.deleteByRecordIdAndCostId(id, 1);
        // 删除入住记录
        stayRecordMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateCost(Integer recordId) {
        List<CustomerCostDO> customerCostDOS = customerCostMapper.listByRecordId(recordId);
        Optional<CustomerCostDO> result = customerCostDOS.stream()
                .filter(customerCostDO -> Objects.equals(customerCostDO.getStatus(), CustomerCostStatusEnum.NOT_PAY.getCode()))
                .findAny();
        StayRecordDO stayRecordDO = new StayRecordDO();
        stayRecordDO.setId(recordId);
        if (result.isPresent()) {
            stayRecordDO.setCostStatus(CustomerCostStatusEnum.NOT_PAY.getCode());
        } else {
            stayRecordDO.setCostStatus(CustomerCostStatusEnum.PAY.getCode());
        }
        stayRecordMapper.updateByPrimaryKeySelective(stayRecordDO);
    }

    @Override
    public void pay(Integer recordId) {
        customerCostMapper.updateCostStatus(recordId);
        StayRecordDO stayRecordDO = new StayRecordDO();
        stayRecordDO.setId(recordId);
        stayRecordDO.setCostStatus(CustomerCostStatusEnum.FINISH.getCode());
        stayRecordMapper.updateByPrimaryKeySelective(stayRecordDO);
    }

    @Override
    public PayVO settlement(Integer recordId) {
        // 更新退房时间
        StayRecordDO stayRecordDO = new StayRecordDO();
        stayRecordDO.setId(recordId);
        Date currentTime = new Date();
        stayRecordDO.setOutTime(currentTime);
        stayRecordMapper.updateByPrimaryKeySelective(stayRecordDO);

        // 判断是否存在超时费
        stayRecordDO = stayRecordMapper.selectByPrimaryKey(recordId);
        if (stayRecordDO.getOutTime().after(stayRecordDO.getReserveOutTime())) {
            CustomerCostDO customerCostDO = new CustomerCostDO();
            customerCostDO.setRecordId(recordId);
            customerCostDO.setCostId(2);
            customerCostDO.setCostValue(50.0D);
            customerCostDO.setDiscount(1.0D);
            customerCostDO.setStatus(CustomerCostStatusEnum.NOT_PAY.getCode());
            customerCostMapper.insertSelective(customerCostDO);
        }
        AtomicReference<Double> notPay = new AtomicReference<>(0.0D);
        customerCostMapper.listByRecordId(recordId)
                .stream()
                .filter(customerCostDO -> Objects.equals(customerCostDO.getCostValue(), CustomerCostStatusEnum.NOT_PAY.getCode()))
                .forEach(customerCostDO -> notPay.updateAndGet(v -> v + customerCostDO.getDiscount() * customerCostDO.getCostValue()));

        PayVO payVO = new PayVO();
        payVO.setNotPay(notPay.get());
        payVO.setId(recordId);
        return payVO;
    }

    private void check(Integer roomId, Date reserveTime) {
        Optional<StayRecordDO> result = stayRecordMapper.listByTime(reserveTime)
                .stream()
                .filter(stayRecordDO -> Objects.equals(stayRecordDO.getRoomId(), roomId))
                .findFirst();
        if (result.isPresent()) {
            StayRecordDO stayRecordDO = result.get();
            throw new CommonException(CommonErrorCode.RESOURCE_EXIT, String.format("房间号：%s的房间已被预定，请选择%s之后的时间", roomId, stayRecordDO.getReserveOutTime()));

        }
    }
}
