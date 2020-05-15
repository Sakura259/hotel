package com.manager.hotel.controller;

import com.manager.hotel.common.ResultModel;
import com.manager.hotel.core.CostInfoService;
import com.manager.hotel.model.CostInfoDO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author haobai
 * @description:
 * @date 2020-05-15 16:59
 */
@RestController
@RequestMapping("/cost")
public class CostController {

    @Resource
    private CostInfoService costInfoService;

    /**
     * 费用列表
     * @return
     */
    @GetMapping("/list")
    public ResultModel list() {
        List<CostInfoDO> list = costInfoService.list();
        return ResultModel.success(list);
    }
}
