package com.manager.hotel.mapper;

import com.manager.hotel.model.FinancialDO;

import java.util.List;

public interface FinancialMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FinancialDO record);

    int insertSelective(FinancialDO record);

    FinancialDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FinancialDO record);

    int updateByPrimaryKey(FinancialDO record);

    List<FinancialDO> list();
}