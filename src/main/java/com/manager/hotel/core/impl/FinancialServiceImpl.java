package com.manager.hotel.core.impl;

import com.manager.hotel.core.FinancialService;
import com.manager.hotel.mapper.FinancialMapper;
import com.manager.hotel.model.FinancialDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author haobai
 * @description:
 * @date 2020-05-17 00:21
 */
@Slf4j
@Service
public class FinancialServiceImpl implements FinancialService {

    @Resource
    private FinancialMapper financialMapper;

    @Override
    public List<FinancialDO> list() {
        return financialMapper.list();
    }
}
