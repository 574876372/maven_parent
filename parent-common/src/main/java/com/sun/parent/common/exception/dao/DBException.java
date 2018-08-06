package com.sun.parent.common.exception.dao;

import com.sun.parent.common.exception.base.CommonRuntimeException;
import com.sun.parent.common.exception.base.IErrorCode;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.common.exception.biz.dao.DBException.java
 * @Date 11:03 2018/7/24
 * To change this template use File | Settings | File Templates.
 */
public class DBException extends CommonRuntimeException {

    public DBException(IErrorCode errorCodeObj){
        super(errorCodeObj);
    }

    public DBException(IErrorCode errorCodeObj, Throwable cause) {
        super(errorCodeObj, cause);
    }

    public DBException(String errorCode, String message) {
        super(errorCode, message);
    }

    public DBException(String errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }
}
