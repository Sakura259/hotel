package com.manager.hotel.mapper;

import com.manager.hotel.model.CostInfoDO;

import java.util.List;

public interface CostInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CostInfoDO record);

    int insertSelective(CostInfoDO record);

    CostInfoDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CostInfoDO record);

    int updateByPrimaryKey(CostInfoDO record);

    List<CostInfoDO> list();
}