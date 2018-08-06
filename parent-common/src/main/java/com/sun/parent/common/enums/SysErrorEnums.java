package com.sun.parent.common.enums;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.common.enums.SysError.java
 * @Date 16:07 2018/8/3
 * To change this template use File | Settings | File Templates.
 */
public enum SysErrorEnums {


    SYS_ERR_999999("999999","系统错误"),

    ;

    private String code;

    private String msg;

    SysErrorEnums(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
