package com.sun.parent.service.repository.impl;

import com.sun.parent.common.enums.CommonErrorCode;
import com.sun.parent.common.enums.CommonLogType;
import com.sun.parent.common.enums.LockStatusEnums;
import com.sun.parent.common.exception.dao.DBException;
import com.sun.parent.common.logger.LoggerAdapter;
import com.sun.parent.common.logger.LoggerAdapterFactory;
import com.sun.parent.dao.mapper.TaskLockDOMapper;
import com.sun.parent.dao.model.TaskLockDO;
import com.sun.parent.service.repository.TaskLockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.service.repository.impl.TaskLockServiceImpl.java
 * @Date 16:21 2018/8/17
 * To change this template use File | Settings | File Templates.
 */
@Service("taskLockService")
public class TaskLockServiceImpl implements TaskLockService {

    protected static final LoggerAdapter LOGGER = LoggerAdapterFactory.getLogger(CommonLogType.SYS_DAL.getLogName());

    @Autowired
    private TaskLockDOMapper taskLockDOMapper;

    @Override
    public boolean isExistsByTypeAndId(String businessType, String businessId) throws DBException {
        try {
            return taskLockDOMapper.isExistsByTypeAndId(businessType,businessId)>0 ? true:false;
        }catch (Exception e){
            LOGGER.error("根据businessType和businessId判断是否存在数据出错,businessType=[{}],businessId=[{}]", businessType, businessId);
            throw new DBException(CommonErrorCode.COMMON_200, e);
        }
    }

    @Override
    public Integer addData(String businessType, String businessId) throws DBException {
        Date cur = new Date();
        TaskLockDO o = new TaskLockDO();
        o.setBusinessType(businessType);
        o.setBusinessId(businessId);
        o.setIsFinished(LockStatusEnums.UNLOCKED.getStatus());
        o.setTaskStatus(LockStatusEnums.UNLOCKED.getStatus());
        o.setCreateTime(cur);
        o.setUpdateTime(cur);
        try {
            return taskLockDOMapper.insertData(o);
        } catch (Exception e) {
            LOGGER.error("新增一条加锁记录异常", e);
            throw new DBException(CommonErrorCode.COMMON_201, e);
        }
    }


    @Override
    public boolean updateLockTask(String businessType, String businessId) throws DBException {
        TaskLockDO o = new TaskLockDO();
        o.setBusinessType(businessType);
        o.setBusinessId(businessId);
        o.setUpdateTime(new Date());
        try {
            return taskLockDOMapper.updateLock(o) > 0 ? true : false;
        } catch (Exception e) {
            LOGGER.error("尝试锁定任务出错,businessType=[{}],businessId=[{}]", businessType, businessId, e);
            throw new DBException(CommonErrorCode.COMMON_202, e);
        }
    }

    @Override
    public boolean updateUnLockTask(String businessType, String businessId) throws DBException {
        TaskLockDO o = new TaskLockDO();
        o.setBusinessType(businessType);
        o.setBusinessId(businessId);
        o.setUpdateTime(new Date());
        try {
            return taskLockDOMapper.updateUnLock(o) > 0 ? true : false;
        } catch (Exception e) {
            LOGGER.error("尝试解锁任务出错,businessType=[{}],businessId=[{}]", businessType, businessId);
            throw new DBException(CommonErrorCode.COMMON_202, e);
        }
    }
}
