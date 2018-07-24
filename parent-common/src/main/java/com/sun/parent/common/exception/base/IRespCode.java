package com.sun.parent.common.exception.base;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.common.exception.base.IRespCode.java
 * @Date 11:11 2018/7/24
 * To change this template use File | Settings | File Templates.
 */
public interface IRespCode {

    String getRespCode();

    String getRespMsg();

    IRespCode getCurrentCodeObj();

    IRespCode getCurrentObjByCode(String var1);
}
