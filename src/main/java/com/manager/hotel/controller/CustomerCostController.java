package com.manager.hotel.controller;

import com.manager.hotel.common.ResultModel;
import com.manager.hotel.core.CustomerCostService;
import com.manager.hotel.core.StayRecordService;
import com.manager.hotel.enums.CustomerCostStatusEnum;
import com.manager.hotel.model.CustomerCostDO;
import com.manager.hotel.vo.CustomerCostVO;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

    @Resource
    private StayRecordService stayRecordService;

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
     * 修改费用
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
