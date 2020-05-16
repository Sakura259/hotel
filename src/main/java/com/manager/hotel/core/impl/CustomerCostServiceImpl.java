package com.manager.hotel.core.impl;

import com.google.common.collect.Lists;
import com.manager.hotel.core.CustomerCostService;
import com.manager.hotel.core.StayRecordService;
import com.manager.hotel.enums.CustomerCostStatusEnum;
import com.manager.hotel.mapper.CostInfoMapper;
import com.manager.hotel.mapper.CustomerCostMapper;
import com.manager.hotel.model.CostInfoDO;
import com.manager.hotel.model.CustomerCostDO;
import com.manager.hotel.vo.CustomerCostDetailVO;
import com.manager.hotel.vo.CustomerCostVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author haobai
 * @description:
 * @date 2020-05-15 13:37
 */
@Slf4j
@Service
public class CustomerCostServiceImpl implements CustomerCostService {

    @Resource
    private CustomerCostMapper customerCostMapper;

    @Resource
    private StayRecordService stayRecordService;

    @Resource
    private CostInfoMapper costInfoMapper;

    @Override
    public void create(CustomerCostVO customerCostVO) {
        CustomerCostDO customerCostDO = new CustomerCostDO();
        BeanUtils.copyProperties(customerCostVO, customerCostDO);
        customerCostDO.setStatus(CustomerCostStatusEnum.NOT_PAY.getCode());
        // 新增费用记录
        customerCostMapper.insertSelective(customerCostDO);
        // 修改订单状态
        stayRecordService.updateCost(customerCostDO.getRecordId());
    }

    @Override
    public void update(CustomerCostVO customerCostVO) {
        CustomerCostDO customerCostDO = new CustomerCostDO();
        BeanUtils.copyProperties(customerCostVO, customerCostDO);
        customerCostDO.setStatus(CustomerCostStatusEnum.NOT_PAY.getCode());
        log.info("customerCostDO:{}", customerCostDO);
        // 修改费用记录
        customerCostMapper.updateByPrimaryKeySelective(customerCostDO);
    }

    @Override
    public void delete(Integer recordId, Integer costId) {
        customerCostMapper.deleteByRecordIdAndCostId(recordId, costId);
        stayRecordService.updateCost(recordId);
    }

    @Override
    public List<CustomerCostDetailVO> get(Integer recordId) {
        Map<Integer, CostInfoDO> map = costInfoMapper.list()
                .stream()
                .collect(Collectors.toMap(CostInfoDO::getId, costInfoDO -> costInfoDO));
        List<CustomerCostDetailVO> list = customerCostMapper.listByRecordId(recordId)
                .stream()
                .map(customerCostDO -> {
                    CostInfoDO costInfoDO = map.get(customerCostDO.getCostId());
                    CustomerCostDetailVO customerCostDetailVO = new CustomerCostDetailVO();
                    BeanUtils.copyProperties(customerCostDO, customerCostDetailVO);
                    customerCostDetailVO.setCostName(costInfoDO.getCostName());
                    return customerCostDetailVO;
                }).collect(Collectors.toList());
        return list;
    }
}
