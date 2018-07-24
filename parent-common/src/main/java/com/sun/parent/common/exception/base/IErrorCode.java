package com.sun.parent.common.exception.base;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.common.exception.base.IErrorCode.java
 * @Date 11:11 2018/7/24
 * To change this template use File | Settings | File Templates.
 */
public interface IErrorCode {

    String getErrorCode();

    String getErrorMsg();

    IRespCode getRespCodeObj();

    IErrorCode getCurrentCodeObj();

    IErrorCode getCurrentObjByCode(String var1);

}
