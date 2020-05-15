package com.manager.hotel.mapper;

import com.manager.hotel.model.StayRecordDO;

import java.util.List;

public interface StayRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(StayRecordDO record);

    StayRecordDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StayRecordDO record);

    int updateByPrimaryKey(StayRecordDO record);

    List<StayRecordDO> list();

}