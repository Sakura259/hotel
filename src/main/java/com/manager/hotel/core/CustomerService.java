package com.manager.hotel.core;

import com.manager.hotel.vo.CustomerVO;

/**
 * @author haobai
 * @description:
 * @date 2020-05-15 02:25
 */
public interface CustomerService {

    void create(CustomerVO customerVO);

    void update(CustomerVO customerVO);
}
