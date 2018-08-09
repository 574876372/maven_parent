package com.sun.parent.common.exception.param;

import com.sun.parent.common.exception.base.IErrorCode;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.common.exception.param.ParamCheckException.java
 * @Date 17:49 2018/8/8
 * To change this template use File | Settings | File Templates.
 */
public class ParamCheckException extends CheckException{

    public ParamCheckException(IErrorCode errorCodeObj) {
        super(errorCodeObj);
    }

    public ParamCheckException(String errorCode, String message) {
        super(errorCode, message);
    }

    public ParamCheckException(String errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }
}
