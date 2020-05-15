package com.manager.hotel.mapper;

import com.manager.hotel.model.StayRecordDO;

public interface StayRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StayRecordDO record);

    int insertSelective(StayRecordDO record);

    StayRecordDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StayRecordDO record);

    int updateByPrimaryKey(StayRecordDO record);
}