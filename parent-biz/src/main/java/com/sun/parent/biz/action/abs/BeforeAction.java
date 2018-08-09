package com.sun.parent.biz.action.abs;

import com.sun.parent.common.exception.base.CommonException;

import java.util.Map;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.biz.action.abs.BeforeBusiness.java
 * @Date 10:17 2018/8/9
 * To change this template use File | Settings | File Templates.
 */
public interface BeforeAction<V> {

    /**
     * 接口开始
     *
     * @param request
     * @param paramMap
     * @throws CommonException
     */
    public abstract void before(V request, Map<String, Object> paramMap) throws CommonException;
}
