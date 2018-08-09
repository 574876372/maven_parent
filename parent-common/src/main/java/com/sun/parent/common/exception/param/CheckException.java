package com.sun.parent.common.exception.param;

import com.sun.parent.common.exception.base.CommonException;
import com.sun.parent.common.exception.base.IErrorCode;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.common.exception.param.CheckException.java
 * @Date 17:48 2018/8/8
 * To change this template use File | Settings | File Templates.
 */
public class CheckException extends CommonException {

    public CheckException(IErrorCode errorCodeObj) {
        super(errorCodeObj);
    }

    public CheckException(IErrorCode errorCodeObj, Throwable cause) {
        super(errorCodeObj, cause);
    }

    public CheckException(String errorCode, String message) {
        super(errorCode, message);
    }

    public CheckException(String errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }
}
