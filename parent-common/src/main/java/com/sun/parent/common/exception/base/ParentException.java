package com.sun.parent.common.exception.base;

import com.sun.parent.common.enums.SysErrorEnums;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.common.exception.base.CommonRuntimeException.java
 * @Date 15:33 2018/8/3
 * To change this template use File | Settings | File Templates.
 */
public class ParentException extends RuntimeException implements BasisMI{

    private final String code;

    private String msg;


    public ParentException() {
        super("Business Error");
        this.code = SysErrorEnums.SYS_ERR_999999.getCode();
        this.msg = SysErrorEnums.SYS_ERR_999999.getMsg();
    }

    public ParentException(String code) {
        super("Business Error");
        this.code = code;
        this.msg = "Business Error";
    }

    public ParentException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public ParentException(String code, Throwable ex) {
        super(code, ex);
        this.code = code;
        this.msg = ex.getMessage();
    }

    public ParentException(String code, String msg, Throwable ex) {
        super(code, ex);
        this.code = code;
        this.msg = msg;
    }


    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }

}
