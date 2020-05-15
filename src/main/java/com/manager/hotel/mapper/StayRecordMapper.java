package com.manager.hotel.mapper;

import com.manager.hotel.model.StayRecordDO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface StayRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(StayRecordDO record);

    StayRecordDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StayRecordDO record);

    List<StayRecordDO> list();

    List<StayRecordDO> listByTime(@Param("date") Date date);

}