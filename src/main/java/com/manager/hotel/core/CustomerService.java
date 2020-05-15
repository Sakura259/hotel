package com.manager.hotel.core;

import com.manager.hotel.model.CustomerDO;
import com.manager.hotel.vo.CustomerVO;

/**
 * @author haobai
 * @description:
 * @date 2020-05-15 02:25
 */
public interface CustomerService {

    Integer create(CustomerVO customerVO);

    void update(CustomerVO customerVO);

    CustomerDO get(Integer id);

    void delete(Integer id);
}
