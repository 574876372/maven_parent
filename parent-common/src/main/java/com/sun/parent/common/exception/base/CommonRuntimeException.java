package com.sun.parent.common.exception.base;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.common.exception.base.CommonRuntimeException.java
 * @Date 16:58 2018/8/3
 * To change this template use File | Settings | File Templates.
 */
public class CommonRuntimeException extends ParentException{

    protected IErrorCode iErrorCode;

    public CommonRuntimeException(IErrorCode errorCodeObj, Throwable cause) {
        super(errorCodeObj.getErrorCode(), errorCodeObj.getErrorMsg(), cause);
        this.iErrorCode = errorCodeObj;
    }

    public CommonRuntimeException(IErrorCode errorCodeObj) {
        super(errorCodeObj.getErrorCode(), errorCodeObj.getErrorMsg());
        this.iErrorCode = errorCodeObj;
    }

    public CommonRuntimeException(String code, String msg) {
        super(code, msg);
    }

    public CommonRuntimeException(String code, String msg, Throwable cause) {
        super(code, msg, cause);
    }

    public IErrorCode getiErrorCode() {
        return iErrorCode;
    }

    public void setiErrorCode(IErrorCode iErrorCode) {
        this.iErrorCode = iErrorCode;
    }
}
