package com.manager.hotel.mapper;

import com.manager.hotel.model.CustomerCostDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerCostMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteByRecordIdAndCostId(@Param("recordId") Integer recordId, @Param("costId")Integer costId);

    int insert(CustomerCostDO record);

    int insertSelective(CustomerCostDO record);

    CustomerCostDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CustomerCostDO record);

    int updateByPrimaryKey(CustomerCostDO record);

    List<CustomerCostDO> list();

    List<CustomerCostDO> listByRecordId(Integer recordId);
}