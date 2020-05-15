package com.manager.hotel.core;

import com.manager.hotel.model.CostInfoDO;

import java.util.List;

/**
 * @author haobai
 * @description:
 * @date 2020-05-15 17:10
 */
public interface CostInfoService {

    List<CostInfoDO> list();

    void create(CostInfoDO costInfoDO);

    void update(CostInfoDO costInfoDO);

    void delete(Integer id);
}
