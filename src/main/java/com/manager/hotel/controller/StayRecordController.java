package com.manager.hotel.controller;

import com.manager.hotel.common.ResultModel;
import com.manager.hotel.core.StayRecordService;
import com.manager.hotel.model.StayRecordDO;
import com.manager.hotel.vo.AddStayRecordVO;
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
        List<StayRecordDO> list = stayRecordService.list();
        return ResultModel.success(list);
    }

    @PostMapping("/create")
    public ResultModel create(@RequestBody AddStayRecordVO addStayRecordVO) {
        stayRecordService.create(addStayRecordVO);
        return ResultModel.success("新增订单成功");
    }
}
