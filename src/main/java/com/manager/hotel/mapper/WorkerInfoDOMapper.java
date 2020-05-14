package com.manager.hotel.mapper;

import com.manager.hotel.model.WorkerInfoDO;

public interface WorkerInfoDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WorkerInfoDO record);

    int insertSelective(WorkerInfoDO record);

    WorkerInfoDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WorkerInfoDO record);

    int updateByPrimaryKey(WorkerInfoDO record);
}