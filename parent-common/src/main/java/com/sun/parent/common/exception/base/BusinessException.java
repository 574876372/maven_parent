package com.sun.parent.common.exception.base;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.common.exception.base.BusinessException.java
 * @Date 17:16 2018/8/3
 * To change this template use File | Settings | File Templates.
 */
public class BusinessException extends CommonException {

    public BusinessException(IErrorCode errorCodeObj) {
        super(errorCodeObj);
    }

    public BusinessException(IErrorCode errorCodeObj, Throwable cause) {
        super(errorCodeObj, cause);
    }

    public BusinessException(String errorCode, String message) {
        super(errorCode, message);
    }

    public BusinessException(String errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }
}
