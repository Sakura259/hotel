package com.manager.hotel.controller;

import com.manager.hotel.common.ResultModel;
import com.manager.hotel.core.CustomerCostService;
import com.manager.hotel.core.StayRecordService;
import com.manager.hotel.vo.CustomerCostDetailVO;
import com.manager.hotel.vo.CustomerCostVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author haobai
 * @description:
 * @date 2020-05-15 17:17
 */
@RestController
@RequestMapping("/customer/cost")
public class CustomerCostController {

    @Resource
    private CustomerCostService customerCostService;

    @GetMapping("/get")
    public ResultModel get(@RequestParam("recordId") Integer recordId) {
        List<CustomerCostDetailVO> list = customerCostService.get(recordId);
        return ResultModel.success(list);
    }

    /**
     * 新增额外费用
     * @param customerCostVO
     * @return
     */
    @PostMapping("/create")
    public ResultModel create(@RequestBody CustomerCostVO customerCostVO) {
        customerCostService.create(customerCostVO);
        return ResultModel.success();
    }

    /**
     * 修改费用
     * @param customerCostVO
     * @return
     */
    @PostMapping("/update")
    public ResultModel update(@RequestBody CustomerCostVO customerCostVO) {

        customerCostService.update(customerCostVO);
        return ResultModel.success();
    }

    /**
     * 删除费用
     * @param customerCostVO
     * @return
     */
    @PostMapping("/delete")
    public ResultModel delete(@RequestBody CustomerCostVO customerCostVO) {
        // 删除费用记录
        customerCostService.delete(customerCostVO.getRecordId(), customerCostVO.getCostId());
        return ResultModel.success();
    }
}
