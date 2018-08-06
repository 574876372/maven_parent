package com.sun.parent.common.enums;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.common.enums.CommonLogType.java
 * @Date 16:31 2018/8/6
 * To change this template use File | Settings | File Templates.
 */
public enum  CommonLogType {

    SYS_CONTROLLER("sys.controller"),
    SYS_BIZ("sys.biz"),
    SYS_INTEGRATION("sys.integration"),
    SYS_SERVICE("sys.service"),
    SYS_COMMON("sys.common"),
    SYS_DAL("sys.dao"),
    SYS_ERRORPOLICY("sys.errorpolicy"),
    SYS_PERFORMANCE("sys.performance");

    private String logName;

    CommonLogType(String logName) {
        this.logName = logName;
    }

    public String getLogName() {
        return logName;
    }
}
