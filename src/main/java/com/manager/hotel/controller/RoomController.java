package com.manager.hotel.controller;

import com.alibaba.fastjson.JSON;
import com.manager.hotel.common.CommonErrorCode;
import com.manager.hotel.common.ResultModel;
import com.manager.hotel.core.RoomService;
import com.manager.hotel.model.RoomDO;
import com.manager.hotel.vo.BaseVO;
import com.manager.hotel.vo.RoomVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author haobai
 * @description:
 * @date 2020-05-15 00:56
 */
@Slf4j
@RestController
@RequestMapping("/room")
public class RoomController {

    @Resource
    private RoomService roomService;

    @GetMapping("/list")
    public ResultModel query(@RequestParam(value = "roomType", required = false) Integer roomType,
                             @RequestParam(value = "stayStatus", required = false) Integer stayStatus,
                             @RequestParam(value = "cleanStatus", required = false) Integer cleanStatus) {
        List<RoomDO> query = roomService.query(roomType, stayStatus, cleanStatus);
        log.info(JSON.toJSONString(query));
        return ResultModel.success(query);
    }

    @PostMapping("/create")
    public ResultModel create(@Validated @RequestBody RoomVO roomVO) {
        roomService.create(roomVO);
        return ResultModel.success("新增房间成功");
    }

    @PostMapping("/update")
    public ResultModel update(@Validated @RequestBody RoomVO roomVO) {
        roomService.update(roomVO);
        return ResultModel.success("更新房间成功");
    }

    @PostMapping("/delete")
    public ResultModel delete(@RequestBody BaseVO baseVO) {
        Boolean result = roomService.delete(baseVO.getId());
        if (result) {
            return ResultModel.success("删除房间成功");
        } else {
            return ResultModel.fail(CommonErrorCode.UNKNOWN_ERROR);
        }
    }
}
