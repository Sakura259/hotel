package com.manager.hotel.core.impl;

import com.manager.hotel.core.CostInfoService;
import com.manager.hotel.mapper.CostInfoMapper;
import com.manager.hotel.model.CostInfoDO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author haobai
 * @description:
 * @date 2020-05-15 17:10
 */
@Service
public class CostInfoServiceImpl implements CostInfoService {

    @Resource
    private CostInfoMapper costInfoMapper;
    @Override
    public List<CostInfoDO> list() {
        return costInfoMapper.list();
    }

    @Override
    public void create(CostInfoDO costInfoDO) {
        costInfoMapper.insertSelective(costInfoDO);
    }

    @Override
    public void update(CostInfoDO costInfoDO) {
        costInfoMapper.updateByPrimaryKeySelective(costInfoDO);
    }

    @Override
    public void delete(Integer id) {
        costInfoMapper.deleteByPrimaryKey(id);
    }
}
