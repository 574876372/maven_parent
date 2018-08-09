package com.sun.parent.biz.action.abs;

import com.sun.parent.common.exception.base.CommonException;

import java.util.Map;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.biz.action.abs.AfterAction.java
 * @Date 10:28 2018/8/9
 * To change this template use File | Settings | File Templates.
 */
public interface AfterAction<T,V> {
    /**
     * 执行后
     * @param response
     * @param requset
     * @param paramMap
     * @throws CommonException
     */
    public abstract void after(T response, V requset, Map<String, Object> paramMap) throws CommonException;
}
