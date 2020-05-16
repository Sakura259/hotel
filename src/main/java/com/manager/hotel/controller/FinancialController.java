package com.manager.hotel.controller;

import com.manager.hotel.common.ResultModel;
import com.manager.hotel.core.FinancialService;
import com.manager.hotel.model.FinancialDO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author haobai
 * @description:
 * @date 2020-05-16 23:58
 */
@RestController
@RequestMapping("/financial")
public class FinancialController {

    @Resource
    private FinancialService financialService;

    @GetMapping("/list")
    public ResultModel list() {
        List<FinancialDO> list = financialService.list();
        return ResultModel.success(list);
    }
}
