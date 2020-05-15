package com.manager.hotel.core.impl;

import com.manager.hotel.common.CommonErrorCode;
import com.manager.hotel.common.CommonException;
import com.manager.hotel.common.ResultModel;
import com.manager.hotel.core.WorkerService;
import com.manager.hotel.mapper.WorkerMapper;
import com.manager.hotel.model.WorkerDO;
import com.manager.hotel.vo.WorkerLoginVO;
import com.manager.hotel.vo.WorkerVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @author haobai
 * @description:
 * @date 2020-05-14 23:36
 */
@Service
public class WorkerServiceImpl implements WorkerService {

    @Resource
    private WorkerMapper workerMapper;

    @Override
    public WorkerDO login(WorkerLoginVO workerLoginVO) {
        WorkerDO workerDO = workerMapper.getByName(workerLoginVO.getName());
        if (Objects.isNull(workerDO)) {
            throw new CommonException(CommonErrorCode.RESOURCE_NOT_FOUND, "不存在的员工");
        }
        if (!StringUtils.equals(workerDO.getPassword(), workerLoginVO.getPassword())) {
            throw new CommonException(CommonErrorCode.RESOURCE_NOT_FOUND, "密码错误，请重新输入");
        }
        return workerDO;
    }

    @Override
    public void logout(Integer id) {
        WorkerDO workerDO = workerMapper.selectByPrimaryKey(id);
        if (Objects.isNull(workerDO)) {
            throw new CommonException(CommonErrorCode.RESOURCE_NOT_FOUND, "不存在的员工,退出失败");
        }
    }

    @Override
    public void create(WorkerVO workerVO) {
        WorkerDO workerDO = workerMapper.getByName(workerVO.getName());
        if (Objects.nonNull(workerDO)) {
            throw new CommonException(CommonErrorCode.RESOURCE_EXIT, "员工名已存在，请重新命名");
        }
        workerDO = new WorkerDO();
        BeanUtils.copyProperties(workerVO, workerDO);
        workerMapper.insertSelective(workerDO);
    }

    @Override
    public void update(WorkerVO workerVO) {
        if (Objects.isNull(workerVO.getId())) {
            throw new CommonException(CommonErrorCode.RESOURCE_EXIT, "员工id不能为空");
        }
        WorkerDO workerDO = workerMapper.getByName(workerVO.getName());
        if (!Objects.equals(workerDO.getId(), workerVO.getId())) {
            throw new CommonException(CommonErrorCode.RESOURCE_EXIT, "员工名已存在，请重新命名");
        }
        workerDO = new WorkerDO();
        BeanUtils.copyProperties(workerVO, workerDO);
        workerMapper.updateByPrimaryKeySelective(workerDO);
    }

    @Override
    public Boolean delete(Integer id) {
        int delete = workerMapper.deleteByPrimaryKey(id);
        return delete > 0 ? true : false;
    }

    @Override
    public List<WorkerDO> list() {
        return workerMapper.list();
    }
}
