package com.sun.parent.service.bussiness.impl;

import com.sun.parent.common.enums.CommonErrorCode;
import com.sun.parent.common.enums.CommonLogType;
import com.sun.parent.common.exception.dao.DBException;
import com.sun.parent.common.logger.LoggerAdapter;
import com.sun.parent.common.logger.LoggerAdapterFactory;
import com.sun.parent.service.bussiness.TaskLockBusService;
import com.sun.parent.service.repository.TaskLockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.service.bussiness.impl.TaskLockBusServiceImpl.java
 * @Date 16:24 2018/8/17
 * To change this template use File | Settings | File Templates.
 */
@Service("taskLockBusService")
public class TaskLockBusServiceImpl implements TaskLockBusService {

    protected static final LoggerAdapter LOGGER = LoggerAdapterFactory.getLogger(CommonLogType.SYS_DAL.getLogName());

    @Autowired
    private TaskLockService taskLockService;

    @Autowired
    protected TransactionTemplate transactionTemplate;

    @Override
    public boolean lockTask(String businessType, String businessId) {
        final String sendBusinessType = businessType;
        final String sendBusinessId = businessId;
        boolean isExist = false;
        try {
            isExist = taskLockService.isExistsByTypeAndId(sendBusinessType, sendBusinessId);
        } catch (DBException e) {
            LOGGER.error("尝试锁定任务出错,businessType=[{}],businessId=[{}]", sendBusinessType, sendBusinessId, e);
            return false;
        }
        if (!isExist) {
            try {
                boolean resultVal = transactionTemplate.execute(new TransactionCallback<Boolean>() {
                    @Override
                    public Boolean doInTransaction(TransactionStatus status) {
                        taskLockService.addData(sendBusinessType, sendBusinessId);
                        boolean updateFlag = taskLockService.updateLockTask(sendBusinessType, sendBusinessId);
                        if (!updateFlag) {
                            throw new DBException(CommonErrorCode.COMMON_202);
                        }
                        return updateFlag;
                    }
                });
                return resultVal;
            } catch (Exception e) {
                LOGGER.error("尝试锁定任务出错,businessType=[{}],businessId=[{}]", businessType, businessId, e);
                return false;
            }
        } else {
            try {
                return taskLockService.updateLockTask(businessType, businessId);
            } catch (Exception e) {
                LOGGER.error("尝试锁定任务出错,businessType=[{}],businessId=[{}]", businessType, businessId, e);
                return false;
            }
        }
    }


    @Override
    public boolean unLockTask(String businessType, String businessId) {
        try {
            return taskLockService.updateUnLockTask(businessType, businessId);
        } catch (Exception e) {
            LOGGER.error("尝试解锁任务出错,businessType=[{}],businessId=[{}]", businessType, businessId, e);
            return false;
        }
    }
}
