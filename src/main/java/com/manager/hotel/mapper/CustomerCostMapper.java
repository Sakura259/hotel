package com.manager.hotel.mapper;

import com.manager.hotel.model.CustomerCostDO;

public interface CustomerCostMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CustomerCostDO record);

    int insertSelective(CustomerCostDO record);

    CustomerCostDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CustomerCostDO record);

    int updateByPrimaryKey(CustomerCostDO record);
}