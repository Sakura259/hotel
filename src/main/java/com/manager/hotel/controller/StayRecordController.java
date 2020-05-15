package com.manager.hotel.controller;

import com.manager.hotel.common.ResultModel;
import com.manager.hotel.core.StayRecordService;
import com.manager.hotel.model.StayRecordDO;
import com.manager.hotel.vo.AddStayRecordVO;
import com.manager.hotel.vo.BaseVO;
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

    @GetMapping("/list")
    public ResultModel list() {
        List<StayRecordVO> list = stayRecordService.list();
        return ResultModel.success(list);
    }

    @PostMapping("/create")
    public ResultModel create(@RequestBody AddStayRecordVO addStayRecordVO) {
        stayRecordService.create(addStayRecordVO);
        return ResultModel.success("新增订单成功");
    }

    @PostMapping("/update")
    public ResultModel update(@RequestBody AddStayRecordVO addStayRecordVO) {
        stayRecordService.update(addStayRecordVO);
        return ResultModel.success("修改订单成功");
    }

    @PostMapping("/delete")
    public ResultModel delete(@RequestBody BaseVO baseVO) {
        stayRecordService.delete(baseVO.getId());
        return ResultModel.success("删除订单成功");
    }

}
