package com.manager.hotel.core;

import com.manager.hotel.model.CustomerCostDO;
import com.manager.hotel.vo.CustomerCostDetailVO;
import com.manager.hotel.vo.CustomerCostVO;

import java.util.List;

/**
 * @author haobai
 * @description:
 * @date 2020-05-15 13:37
 */
public interface CustomerCostService {

    void create(CustomerCostVO customerCostVO);

    void update(CustomerCostVO customerCostVO);

    void delete(Integer recordId, Integer costId);

    List<CustomerCostDetailVO> get(Integer recordId);
}
