package com.manager.hotel.mapper;

import com.manager.hotel.model.WorkerDO;
import org.apache.ibatis.annotations.Param;

public interface WorkerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WorkerDO record);

    int insertSelective(WorkerDO record);

    WorkerDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WorkerDO record);

    int updateByPrimaryKey(WorkerDO record);

    WorkerDO getByName(@Param("name") String name);
}