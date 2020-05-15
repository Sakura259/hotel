package com.manager.hotel.core.impl;

import com.manager.hotel.core.CustomerService;
import com.manager.hotel.mapper.CustomerMapper;
import com.manager.hotel.model.CustomerDO;
import com.manager.hotel.vo.CustomerVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author haobai
 * @description:
 * @date 2020-05-15 02:26
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerMapper customerMapper;

    @Override
    public void create(CustomerVO customerVO) {
        CustomerDO customerDO = customerMapper.getByIdNumber(customerVO.getIdNumber());
        if (Objects.nonNull(customerDO)) {
            customerDO.setCustomerType(customerVO.getCustomerType());
            customerDO.setPhone(customerVO.getPhone());
            customerMapper.updateByPrimaryKeySelective(customerDO);
        }
        customerDO = new CustomerDO();
        BeanUtils.copyProperties(customerVO, customerDO);
        customerMapper.insertSelective(customerDO);
    }

    @Override
    public void update(CustomerVO customerVO) {
        CustomerDO customerDO = new CustomerDO();
        BeanUtils.copyProperties(customerVO, customerDO);
        customerMapper.updateByPrimaryKeySelective(customerDO);
    }
}
