package com.manager.hotel.core;

import com.manager.hotel.model.RoomDO;
import com.manager.hotel.vo.RoomVO;

import java.util.List;

/**
 * @author haobai
 * @description:
 * @date 2020-05-15 01:04
 */
public interface RoomService {

    List<RoomDO> query(Integer roomType, Integer stayStatus, Integer cleanStatus);

    void create(RoomVO roomVO);

    void update(RoomVO roomVO);

    Boolean delete(Integer id);
}
