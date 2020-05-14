package com.manager.hotel.controller;

import com.manager.hotel.common.CommonErrorCode;
import com.manager.hotel.common.ResultModel;
import com.manager.hotel.core.WorkerService;
import com.manager.hotel.model.WorkerDO;
import com.manager.hotel.vo.BaseVO;
import com.manager.hotel.vo.WorkerLoginVO;
import com.manager.hotel.vo.WorkerVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author haobai
 * @description:
 * @date 2020-05-14 23:34
 */
@RestController
@RequestMapping("/worker")
public class WorkController {

    @Resource
    private WorkerService workerService;

    @PostMapping("/login")
    public ResultModel login(@Validated @RequestBody WorkerLoginVO workerLoginVO) {
        WorkerDO workerDO = workerService.login(workerLoginVO);
        return ResultModel.success(workerDO);

    }

    @GetMapping("/logout")
    public ResultModel logout(@RequestParam(value = "id") Integer id) {
        workerService.logout(id);
        return ResultModel.success("登出成功");
    }

    @PostMapping("/create")
    public ResultModel create(@Validated @RequestBody WorkerVO workerVO) {
        workerService.create(workerVO);
        return ResultModel.success("新增员工成功");
    }

    @PostMapping("/update")
    public ResultModel update(@Validated @RequestBody WorkerVO workerVO) {
        workerService.update(workerVO);
        return ResultModel.success("更新员工成功");
    }

    @PostMapping("/delete")
    public ResultModel delete(@RequestBody BaseVO delete) {
        Boolean result = workerService.delete(delete.getId());
        if (result) {
            return ResultModel.success("删除员工成功");
        } else {
            return ResultModel.fail(CommonErrorCode.UNKNOWN_ERROR);
        }
    }
}
