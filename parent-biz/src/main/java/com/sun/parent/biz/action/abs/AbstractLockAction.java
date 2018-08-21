package com.sun.parent.biz.action.abs;


import com.sun.parent.common.enums.CommonErrorCode;
import com.sun.parent.common.exception.base.BusinessException;
import com.sun.parent.common.exception.base.CommonException;
import com.sun.parent.common.exception.biz.BizException;
import com.sun.parent.common.exception.param.CheckException;
import com.sun.parent.common.exception.param.ParamCheckException;
import com.sun.parent.facade.bean.abs.AbstractRequest;
import com.sun.parent.facade.bean.abs.AbstractResponse;
import com.sun.parent.service.bussiness.TaskLockBusService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;


/**
 * @Author:ChenLei
 * @Description: com.sun.parent.biz.action.abs.AbstractLockAction.java
 * @Date 15:12 2018/8/17
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractLockAction<T extends AbstractResponse,V extends AbstractRequest> extends  AbstractAction<T,V>{

    @Autowired
    private TaskLockBusService taskLockBusService;

    @Override
    public T excute(V request,String businessType, String businessId) throws CommonException {

        Map<String, Object> paramMap = new HashMap<String, Object>();
        // 接口开始
        before(request, paramMap);
        // 校验动作
        checkParam(request,paramMap, businessType,  businessId);
        //业务处理
        // 加锁
        LOGGER.info("业务类型[{}]绑卡加锁：[{}],", businessType, businessId);
        boolean lockFlag = taskLockBusService.lockTask(businessType, businessId);
        if (!lockFlag) {
            throw new BusinessException(CommonErrorCode.COMMON_101);
        }
        T response = null;
        try {
             response = businessExecute(request,paramMap);
        }catch (CommonException e){
            LOGGER.warn("[{}] 执行会员[{}]业务操作错误  req=[{}] paramMap=[{}]", e.getMessage(), businessType, request, paramMap);
            throw e;
        }finally {
            // 解锁
            LOGGER.info("业务类型[{}]解锁：[{}]", businessType, businessId);
            taskLockBusService.unLockTask(businessType, businessId);
        }
        //公共参数返回
        response = fillAbstractResponse(response,request);
        // 业务逻辑处理后动作
        after(response, request, paramMap);
        return response;
    }

    /**
     * 参数校验
     * @param request
     * @param paramMap
     * @throws BizException
     * @throws ParamCheckException
     * @throws CheckException
     */
    public void checkParam(V request,Map<String, Object> paramMap,String businessType, String businessId) throws BizException, ParamCheckException,CheckException {
        //基础参数校验
        checkParam(request);
        //业务参数校验
        checkBusRule(request, paramMap);
        //业务锁校验
        checkLockParam(businessType,businessId);
    }

    /**
     * 业务锁参数校验
     * @param businessType
     * @param businessId
     */
    private void checkLockParam(String businessType, String businessId) throws BizException{
        if(StringUtils.isBlank(businessType)){
            LOGGER.info("业务锁类型businessType={}不能为空",businessType);
            throw new BizException(CommonErrorCode.COMMON_102.getCurrentCodeObj());
        }
        if(StringUtils.isBlank(businessId)){

        }
    }


}
