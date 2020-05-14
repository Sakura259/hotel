package com.manager.hotel.controller;

import com.manager.hotel.mapper.WorkerInfoDOMapper;
import com.manager.hotel.model.WorkerInfoDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author haobai
 * @description:
 * @date 2020-05-14 21:03
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private WorkerInfoDOMapper workerInfoDOMapper;

    @GetMapping
    public String test() {
        WorkerInfoDO workerInfoDO = workerInfoDOMapper.selectByPrimaryKey(1);
        return workerInfoDO.toString();
    }
}
