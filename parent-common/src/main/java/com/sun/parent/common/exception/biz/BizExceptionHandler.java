package com.sun.parent.common.exception.biz;

import com.sun.parent.common.enums.APPCodeEnum;
import com.sun.parent.common.exception.base.CommonException;
import com.sun.parent.common.exception.base.CommonRuntimeException;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.common.exception.biz.BizExceptionHandler.java
 * @Date 10:39 2018/8/7
 * To change this template use File | Settings | File Templates.
 */
public class BizExceptionHandler {

    private BizExceptionHandler() {
    }

    public static void commonExceptionHandle(APPCodeEnum appCode, CommonException e) throws BizException {
        commonHandle(appCode, e);
    }

    public static void commonRuntimeExceptionHandle(APPCodeEnum appCode, CommonRuntimeException e) throws BizException {
        commonRuntimeException(appCode, e);
    }

    private static void commonRuntimeException(APPCodeEnum appCode, CommonRuntimeException e) throws BizException {
        if (e.getiErrorCode() != null && e.getiErrorCode().getRespCodeObj() != null) {
            throw new BizException(appCode.sysId + e.getiErrorCode().getRespCodeObj().getRespCode(), e.getiErrorCode().getRespCodeObj().getRespMsg() + " 错误信息:[" + e.getMessage() + "]", e);
        } else {
            String responseCode = "";
            if (StringUtils.isNotBlank(e.getCode()) && e.getCode().length() == 6) {
                responseCode = e.getCode();
            } else {
                responseCode = appCode.sysId + e.getCode();
            }

            throw new BizException(responseCode, e.getMsg() + " 错误信息:[" + e.getMessage() + "]", e);
        }
    }

    private static void commonHandle(APPCodeEnum appCode, CommonException e) throws BizException {
        if (e.getErrorCodeObj() != null && e.getErrorCodeObj().getRespCodeObj() != null) {
            throw new BizException(appCode.sysId + e.getErrorCodeObj().getRespCodeObj().getRespCode(), e.getErrorCodeObj().getRespCodeObj().getRespMsg() + " 错误信息:[" + e.getMessage() + "]", e);
        } else {
            String responseCode = "";
            if (StringUtils.isNotBlank(e.getCode()) && e.getCode().length() == 6) {
                responseCode = e.getCode();
            } else {
                responseCode = appCode.sysId + e.getCode();
            }
            throw new BizException(responseCode, e.getMsg() + " 错误信息:[" + e.getMessage() + "]", e);
        }
    }
}
