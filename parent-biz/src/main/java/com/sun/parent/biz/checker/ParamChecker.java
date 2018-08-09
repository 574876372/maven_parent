package com.sun.parent.biz.checker;

import com.sun.parent.common.enums.CommonErrorCode;
import com.sun.parent.common.exception.param.ParamCheckException;
import org.springframework.stereotype.Component;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.common.checker.ParamChecker.java
 * @Date 17:42 2018/8/8
 * To change this template use File | Settings | File Templates.
 */
@Component("paramchecker")
public class ParamChecker implements Checker{

    /**
     * 检查参数
     *
     * @param validatorobj
     * @param groups
     * @throws ParamCheckException
     */
    public void checkParam(Object validatorobj, Class<?>... groups) throws ParamCheckException {
        if (validatorobj == null) throw new ParamCheckException(CommonErrorCode.COMMON_001);
        ParamCheckTool.validatorBean(validatorobj, groups);
    }

}
