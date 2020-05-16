package com.manager.hotel.controller;

import com.manager.hotel.common.ResultModel;
import com.manager.hotel.core.StayRecordService;
import com.manager.hotel.vo.AddStayRecordVO;
import com.manager.hotel.vo.BaseVO;
import com.manager.hotel.vo.PayVO;
import com.manager.hotel.vo.StayRecordVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author haobai
 * @description:
 * @date 2020-05-15 11:58
 */
@Slf4j
@RestController
@RequestMapping("/record")
public class StayRecordController {

    @Resource
    private StayRecordService stayRecordService;

    /**
     * 获取订单列表
     * @return
     */
    @GetMapping("/list")
    public ResultModel list() {
        List<StayRecordVO> list = stayRecordService.list();
        return ResultModel.success(list);
    }

    /**
     * 创建订单
     * @param addStayRecordVO
     * @return
     */
    @PostMapping("/create")
    public ResultModel create(@RequestBody AddStayRecordVO addStayRecordVO) {
        stayRecordService.create(addStayRecordVO);
        return ResultModel.success("新增订单成功");
    }
    /**
     * 修改订单
     * @param addStayRecordVO
     * @return
     */
    @PostMapping("/update")
    public ResultModel update(@RequestBody AddStayRecordVO addStayRecordVO) {
        stayRecordService.update(addStayRecordVO);
        return ResultModel.success("修改订单成功");
    }

    /**
     * 删除订单
     * @param baseVO
     * @return
     */
    @PostMapping("/delete")
    public ResultModel delete(@RequestBody BaseVO baseVO) {
        stayRecordService.delete(baseVO.getId());
        return ResultModel.success("删除订单成功");
    }

    /**
     * 退房结算
     * @param baseVO
     * @return
     */
    @PostMapping("/settlement")
    public ResultModel settlement(@RequestBody BaseVO baseVO) {
        PayVO payVO = stayRecordService.settlement(baseVO.getId());
        return ResultModel.success(payVO);
    }

    /**
     * 支付余款
     * @param baseVO
     * @return
     */
    @PostMapping("/pay")
    public ResultModel pay(@RequestBody BaseVO baseVO) {
        stayRecordService.pay(baseVO.getId());
        return ResultModel.success("付款成功");
    }

}
