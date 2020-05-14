package com.manager.hotel.core;

import com.manager.hotel.model.WorkerDO;
import com.manager.hotel.vo.WorkerLoginVO;
import com.manager.hotel.vo.WorkerVO;

/**
 * @author haobai
 * @description:
 * @date 2020-05-14 23:36
 */
public interface WorkerService {

    WorkerDO login(WorkerLoginVO workerLoginVO);

    void logout(Integer id);

    void create(WorkerVO workerVO);

    void update(WorkerVO workerVO);

    Boolean delete(Integer id);
}
