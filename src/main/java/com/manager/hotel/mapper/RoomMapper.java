package com.manager.hotel.mapper;

import com.manager.hotel.model.RoomDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface RoomMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoomDO record);

    int insertSelective(RoomDO record);

    RoomDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoomDO record);

    int updateByPrimaryKey(RoomDO record);

    RoomDO getByRoomId(Integer roomId);

    List<RoomDO> listByQuery(@Param("roomDO") RoomDO roomDO);

    int updateRoomStatus(Set<Integer> roomIdList);
}