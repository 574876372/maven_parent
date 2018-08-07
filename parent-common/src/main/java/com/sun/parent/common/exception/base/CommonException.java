package com.sun.parent.common.exception.base;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.common.exception.base.impl.CommonException.java
 * @Date 11:05 2018/7/24
 * To change this template use File | Settings | File Templates.
 */
public class CommonException extends Exception implements BasisMI{


    private static final long serialVersionUID = 4123909507070702987L;

    protected final String code;

    protected final String msg;

    protected IErrorCode errorCodeObj;

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }

    public CommonException(IErrorCode errorCodeObj, Throwable cause) {
        super(errorCodeObj.getErrorCode() + ":" + errorCodeObj.getErrorMsg(), cause);
        this.errorCodeObj = errorCodeObj;
        this.code = errorCodeObj.getErrorCode();
        this.msg = errorCodeObj.getErrorMsg();
    }

    public CommonException(IErrorCode errorCodeObj) {
        super(errorCodeObj.getErrorCode() + ":" + errorCodeObj.getErrorMsg());
        this.errorCodeObj = errorCodeObj;
        this.code = errorCodeObj.getErrorCode();
        this.msg = errorCodeObj.getErrorMsg();
    }

    public CommonException(String code, String msg) {
        super(code + ":" + msg);
        this.code = code;
        this.msg = msg;
    }

    public CommonException(String code, String msg, Throwable cause) {
        super(code + ":" + msg, cause);
        this.code = code;
        this.msg = msg;
    }

    public IErrorCode getErrorCodeObj() {
        return errorCodeObj;
    }

    public void setErrorCodeObj(IErrorCode errorCodeObj) {
        this.errorCodeObj = errorCodeObj;
    }
}
