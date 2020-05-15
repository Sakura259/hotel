package com.manager.hotel.controller;

import com.manager.hotel.common.ResultModel;
import com.manager.hotel.core.CustomerService;
import com.manager.hotel.vo.CustomerVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author haobai
 * @description:
 * @date 2020-05-15 02:37
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Resource
    private CustomerService customerService;


    @PostMapping("/update")
    public ResultModel update(@Validated @RequestBody CustomerVO customerVO) {
        customerService.update(customerVO);
        return ResultModel.success("修改客户成功");
    }
}
