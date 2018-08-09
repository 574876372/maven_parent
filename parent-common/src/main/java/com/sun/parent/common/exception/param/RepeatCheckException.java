package com.sun.parent.common.exception.param;

import com.sun.parent.common.exception.base.IErrorCode;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.common.exception.param.RepeatCheckException.java
 * @Date 9:03 2018/8/9
 * To change this template use File | Settings | File Templates.
 */
public class RepeatCheckException extends CheckException{

    public RepeatCheckException(IErrorCode errorCodeObj) {
        super(errorCodeObj);
    }

    public RepeatCheckException(String errorCode, String message) {
        super(errorCode, message);
    }

    public RepeatCheckException(String errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }
}
