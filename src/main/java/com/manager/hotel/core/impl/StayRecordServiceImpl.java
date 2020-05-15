package com.manager.hotel.core.impl;

import com.manager.hotel.core.CustomerCostService;
import com.manager.hotel.core.CustomerService;
import com.manager.hotel.core.StayRecordService;
import com.manager.hotel.mapper.RoomMapper;
import com.manager.hotel.mapper.StayRecordMapper;
import com.manager.hotel.model.CustomerCostDO;
import com.manager.hotel.model.RoomDO;
import com.manager.hotel.model.StayRecordDO;
import com.manager.hotel.vo.AddStayRecordVO;
import com.manager.hotel.vo.CustomerVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author haobai
 * @description:
 * @date 2020-05-15 11:57
 */
@Service
public class StayRecordServiceImpl implements StayRecordService {

    @Resource
    private StayRecordMapper stayRecordMapper;

    @Resource
    private CustomerService customerService;

    @Resource
    private RoomMapper roomMapper;

    @Resource
    private CustomerCostService customerCostService;

    @Override
    public List<StayRecordDO> list() {
        return stayRecordMapper.list();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(AddStayRecordVO addStayRecordVO) {
        // 新增客户信息
        CustomerVO customerVO = addStayRecordVO.getCustomerVO();
        Integer customerId = customerService.create(customerVO);
        // 新增预定信息
        StayRecordDO stayRecordDO = new StayRecordDO();
        stayRecordDO.setCustomerId(customerId);
        stayRecordDO.setCustomerName(customerVO.getCustomerName());
        stayRecordDO.setCustomerType(customerVO.getCustomerType());
        stayRecordDO.setRoomId(addStayRecordVO.getRoomId());
        stayRecordDO.setReserveTime(addStayRecordVO.getReserveTime());
        stayRecordDO.setReserveOutTime(addStayRecordVO.getReserveOutTime());
        stayRecordDO.setCostStatus(0);
        stayRecordMapper.insertSelective(stayRecordDO);
        RoomDO roomDO = roomMapper.getByRoomId(addStayRecordVO.getRoomId());
        Integer recordDOId = stayRecordDO.getId();
        double day = (double) (addStayRecordVO.getReserveTime().getTime() - addStayRecordVO.getReserveOutTime().getTime()) / (24 * 60 * 60 * 1000);
        // 新建消费记录
        CustomerCostDO customerCostDO = new CustomerCostDO();
        customerCostDO.setRecordId(recordDOId);
        // 房费
        customerCostDO.setCostId(1);
        customerCostDO.setCostValue(roomDO.getRoomPrice() * day);
        customerCostDO.setDiscount(1.00D);
        customerCostDO.setStatus(0);
        customerCostService.create(customerCostDO);
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
