package com.sun.parent.common.logger;

import org.slf4j.LoggerFactory;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.common.logger.LoggerAdapterFactory.java
 * @Date 16:53 2018/8/6
 * To change this template use File | Settings | File Templates.
 */
public class LoggerAdapterFactory {

    private LoggerAdapterFactory() {
    }

    public static LoggerAdapter getLogger(String name) {
        return new LoggerAdapter(LoggerFactory.getLogger(name));
    }
}
