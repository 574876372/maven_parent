package com.sun.parent.common.exception.biz;

import com.sun.parent.common.exception.base.CommonException;
import com.sun.parent.common.exception.base.IErrorCode;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.common.exception.biz.dao.BizException.java
 * @Date 11:02 2018/7/24
 * To change this template use File | Settings | File Templates.
 */
public class BizException extends CommonException {

    public BizException(IErrorCode errorCodeObj) {
        super(errorCodeObj);
    }

    public BizException(IErrorCode errorCodeObj, Throwable cause) {
        super(errorCodeObj, cause);
    }

    public BizException(String errorCode, String message) {
        super(errorCode, message);
    }

    public BizException(String errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }
}
