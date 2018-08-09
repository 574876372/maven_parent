package com.sun.parent.biz.checker;

import com.sun.parent.common.exception.param.CheckException;

import java.util.Map;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.biz.checker.BusinessRuleChecker.java
 * @Date 9:45 2018/8/9
 * To change this template use File | Settings | File Templates.
 */
public interface BusinessRuleChecker<V> extends Checker {

    /**
     * 验证业务规则
     *
     * @param request
     * @param checkMap
     * @throws CheckException
     */
    public void checkBusRule(V request, Map<String, Object> checkMap) throws CheckException;
}
