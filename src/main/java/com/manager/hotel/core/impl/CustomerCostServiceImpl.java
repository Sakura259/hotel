package com.manager.hotel.core.impl;

import com.manager.hotel.core.CustomerCostService;
import com.manager.hotel.core.StayRecordService;
import com.manager.hotel.enums.CustomerCostStatusEnum;
import com.manager.hotel.mapper.CustomerCostMapper;
import com.manager.hotel.model.CustomerCostDO;
import com.manager.hotel.vo.CustomerCostVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author haobai
 * @description:
 * @date 2020-05-15 13:37
 */
@Service
public class CustomerCostServiceImpl implements CustomerCostService {

    @Resource
    private CustomerCostMapper customerCostMapper;

    @Resource
    private StayRecordService stayRecordService;

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
        // 修改费用记录
        customerCostMapper.updateByPrimaryKeySelective(customerCostDO);
    }

    @Override
    public void delete(Integer recordId, Integer costId) {
        customerCostMapper.deleteByRecordIdAndCostId(recordId, costId);
        stayRecordService.updateCost(recordId);
    }

}
