package com.sun.parent.biz.checker.proxy;

import com.sun.parent.biz.checker.Checker;
import com.sun.parent.biz.checker.IdempotentChecker;
import com.sun.parent.biz.checker.ParamChecker;
import com.sun.parent.common.exception.param.ParamCheckException;
import com.sun.parent.common.exception.param.RepeatCheckException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.biz.checker.proxy.DefaultCheckerProxy.java
 * @Date 9:47 2018/8/9
 * To change this template use File | Settings | File Templates.
 */
public class DefaultCheckerProxy implements Checker {

    @Autowired
    private ParamChecker paramChecker;

    @Autowired
    private IdempotentChecker idempotentChecker;

    /**
     * 检查参数
     *
     * @param validatorobj
     * @param groups
     * @throws ParamCheckException
     */
    public void checkParam(Object validatorobj, Class<?>... groups) throws ParamCheckException {
        paramChecker.checkParam(validatorobj, groups);
    }

    /**
     * 检查幂等
     *
     * @param obj
     * @param busType
     * @throws RepeatCheckException
     */
    public void checkRepeat(Object obj, String busType) throws RepeatCheckException {
        idempotentChecker.checkRepeat(obj, busType);
    }
}
