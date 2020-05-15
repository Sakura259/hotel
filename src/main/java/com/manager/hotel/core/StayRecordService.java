package com.manager.hotel.core;

import com.manager.hotel.model.StayRecordDO;
import com.manager.hotel.vo.AddStayRecordVO;

import java.util.List;

/**
 * @author haobai
 * @description:
 * @date 2020-05-15 11:57
 */
public interface StayRecordService {

    List<StayRecordDO> list();

    void create(AddStayRecordVO addStayRecordVO);

    void update(AddStayRecordVO addStayRecordVO);

    void delete(Integer id);

    void updateCost(Integer recordId);
}
