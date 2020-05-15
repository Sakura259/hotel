package com.manager.hotel.mapper;

import com.manager.hotel.model.CustomerDO;

public interface CustomerMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(CustomerDO record);

    CustomerDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CustomerDO record);

    int updateByPrimaryKey(CustomerDO record);

    CustomerDO getByIdNumber(String idNumber);
}