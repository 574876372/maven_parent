package com.sun.parent.common.logger;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.common.logger.LoggerAdapter.java
 * @Date 16:46 2018/8/6
 * To change this template use File | Settings | File Templates.
 */
public class LoggerAdapter {

    private final Logger logger;

    public LoggerAdapter(Logger logger) {
        this.logger = logger;
    }

    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }

    public void debug(String format, Object... arguments) {
        logger.debug(format, arguments);
    }

    public void debug(String msg) {
        logger.debug(msg);
    }

    public void info(String format, Object... arguments) {
        logger.info(format, arguments);
    }

    public void info(String msg) {
        logger.info(msg);
    }

    public void warn(String format, Object... arguments) {
        logger.warn(format, arguments);
    }

    public void warn(String msg) {
        logger.warn(msg);
    }

    public void error(String msg, Throwable e) {
        logger.error(msg, e);
    }

    /**
     * 异常消息日志
     *
     * @param msg 异常消息
     * @param e
     */
    public void dbError(String msg, Throwable e) {
        logger.error(msg, e);
    }

    /**
     * dberror
     *
     * @param format 异常格式信息 占位符处理
     * @param arguments
     */
    public void dbError(String format, Object... arguments) {
        logger.error(format, siftException(arguments));
    }


    /**
     * integration 层error日志
     *
     * @param msg
     */
    public void integrationError(String msg) {
        logger.error(msg);
    }

    /**
     * integration 层error日志
     *
     * @param e
     */
    public void integrationError(String code, String msg, Throwable e) {
        if (StringUtils.isNotBlank(code))
            logger.error(code + ":" + msg);
        else
            logger.error(msg);
    }

    /**
     * integration 含占位符
     *
     * @param format 异常格式信息 占位符处理
     */
    public void integrationError(String format, Object... arguments) {
        logger.error(format, siftException(arguments));
    }

    public void error(String format, Object... arguments) {
        logger.error(format, arguments);
        filterException(arguments);
    }

    public void trace(String format, Object... arguments) {
        logger.trace(format, arguments);
    }

    /**
     * 过滤异常信息
     *
     * @param args
     */
    private void filterException(Object[] args) {
        for (Object obj : args) {
            if (obj instanceof Throwable) {
//                CatUtil.traceSystemException((Throwable) obj);
            }
        }
    }



    /**
     * 过滤掉exception
     *
     * @param args
     * @return
     */
    private Object[] siftException(Object[] args) {
        List<Object> arguments = new ArrayList<Object>();
        for (Object obj : args) {
            if (obj instanceof Throwable) {
                continue;
            }
            arguments.add(obj);
        }
        return arguments.toArray();
    }

}
