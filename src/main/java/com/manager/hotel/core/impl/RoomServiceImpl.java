package com.manager.hotel.core.impl;

import com.manager.hotel.common.CommonErrorCode;
import com.manager.hotel.common.CommonException;
import com.manager.hotel.core.RoomService;
import com.manager.hotel.mapper.RoomMapper;
import com.manager.hotel.model.RoomDO;
import com.manager.hotel.vo.RoomVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @author haobai
 * @description:
 * @date 2020-05-15 01:04
 */
@Service
public class RoomServiceImpl implements RoomService {

    @Resource
    private RoomMapper roomMapper;

    @Override
    public List<RoomDO> query(Integer roomType, Integer stayStatus, Integer cleanStatus) {
        RoomDO roomDO = new RoomDO();
        roomDO.setRoomType(roomType);
        roomDO.setStayStatus(stayStatus);
        roomDO.setCleanStatus(cleanStatus);
        List<RoomDO> roomDOS = roomMapper.listByQuery(roomDO);
        return roomDOS;
    }

    @Override
    public void create(RoomVO roomVO) {
        RoomDO roomDO = roomMapper.getByRoomId(roomVO.getRoomId());
        if (Objects.nonNull(roomDO)) {
            throw new CommonException(CommonErrorCode.RESOURCE_EXIT, "已存在相同的房间号");
        }
        roomDO = new RoomDO();
        BeanUtils.copyProperties(roomVO, roomDO);
        roomMapper.insertSelective(roomDO);
    }

    @Override
    public void update(RoomVO roomVO) {
        if (Objects.isNull(roomVO.getId())) {
            throw new CommonException(CommonErrorCode.RESOURCE_EXIT, "房间id不能为空");
        }
        RoomDO roomDO = roomMapper.getByRoomId(roomVO.getRoomId());
        if (Objects.nonNull(roomDO)) {
            throw new CommonException(CommonErrorCode.RESOURCE_EXIT, "已存在相同的房间号");
        }
        roomDO = new RoomDO();
        BeanUtils.copyProperties(roomVO, roomDO);
        roomMapper.updateByPrimaryKeySelective(roomDO);
    }

    @Override
    public Boolean delete(Integer id) {
        int delete = roomMapper.deleteByPrimaryKey(id);
        return delete > 0 ? true : false;

    }
}
