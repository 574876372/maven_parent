package com.sun.parent.biz.action.abs;

import com.sun.parent.biz.checker.BusinessRuleChecker;
import com.sun.parent.biz.checker.proxy.DefaultCheckerProxy;
import com.sun.parent.common.enums.APPCodeEnum;
import com.sun.parent.common.enums.CommonErrorCode;
import com.sun.parent.common.exception.base.CommonException;
import com.sun.parent.facade.bean.abs.AbstractRequest;
import com.sun.parent.facade.bean.abs.AbstractResponse;

import java.util.HashMap;
import java.util.Map;


/**
 * @Author:ChenLei
 * @Description: com.sun.parent.biz.action.AbstractAction.java
 * @Date 16:30 2018/8/8
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractAction<T extends AbstractResponse,V extends AbstractRequest>  extends DefaultCheckerProxy implements BusinessRuleChecker<V>,BeforeAction<V>,AfterAction<T,V>{

    /**
     * 主流程
     * @param request
     * @return
     * @throws CommonException
     */
    public T excute(V request)throws CommonException {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        // 接口开始
        before(request, paramMap);
        // 校验动作
        checkParam(request);
        //业务参数校验
        checkBusRule(request, paramMap);
        //业务处理
        T response = businessExecute(request,paramMap);
        //公共参数返回
        response = fillAbstractResponse(response,request);
        // 业务逻辑处理后动作
        after(response, request, paramMap);
        return response;
    }

    /**
     * 业务处理
     * @param request
     * @param paramMap
     * @return
     * @throws CommonException
     */
    public abstract T businessExecute(V request, Map<String, Object> paramMap) throws CommonException;


    /**
     * 封装响应成功对象
     *
     * @param response
     * @return
     */
    protected T fillAbstractResponse(T response,V request) {
        response.setCode(CommonErrorCode.COMMON_000000.getCode());
        response.setMsg(CommonErrorCode.COMMON_000000.getMsg());
        response.setSysId(APPCodeEnum.KPBF_FRAMEWORK.sysId);
        response.setSysDesc(APPCodeEnum.KPBF_FRAMEWORK.sysDesc);
        response.setReqSerial(request.getReqSerial());
        return response;
    }


}
