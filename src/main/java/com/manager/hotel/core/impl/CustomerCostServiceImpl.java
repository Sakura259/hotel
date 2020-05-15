package com.manager.hotel.core.impl;

import com.manager.hotel.core.CustomerCostService;
import com.manager.hotel.mapper.CustomerCostMapper;
import com.manager.hotel.model.CustomerCostDO;
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
    @Override
    public void create(CustomerCostDO customerCostDO) {
        customerCostMapper.insertSelective(customerCostDO);
    }
}
