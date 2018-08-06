package com.sun.parent.common.exception.base;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.common.exception.base.BusinessRuntimeException.java
 * @Date 11:35 2018/8/6
 * To change this template use File | Settings | File Templates.
 */
public class BusinessRuntimeException extends CommonRuntimeException{

    public BusinessRuntimeException(IErrorCode errorCodeObj) {
        super(errorCodeObj);
    }

    public BusinessRuntimeException(IErrorCode errorCodeObj, Throwable cause) {
        super(errorCodeObj, cause);
    }

    public BusinessRuntimeException(String errorCode, String message) {
        super(errorCode, message);
    }

    public BusinessRuntimeException(String errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }
}
