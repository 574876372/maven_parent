package com.sun.parent.biz.checker;

import com.sun.parent.common.enums.CommonLogType;
import com.sun.parent.common.logger.LoggerAdapter;
import com.sun.parent.common.logger.LoggerAdapterFactory;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.common.checker.Checker.java
 * @Date 17:37 2018/8/8
 * To change this template use File | Settings | File Templates.
 */
public interface Checker {

    public static final LoggerAdapter LOGGER = LoggerAdapterFactory.getLogger(CommonLogType.SYS_BIZ.getLogName());
}
