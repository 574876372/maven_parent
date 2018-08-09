package com.sun.parent.biz.checker;

import com.sun.parent.common.enums.CommonErrorCode;
import com.sun.parent.common.enums.CommonLogType;
import com.sun.parent.common.exception.param.ParamCheckException;
import com.sun.parent.common.logger.LoggerAdapter;
import com.sun.parent.common.logger.LoggerAdapterFactory;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Iterator;
import java.util.Set;


/**
 * @Author:ChenLei
 * @Description: com.sun.parent.biz.checker.ParamCheckTool.java
 * @Date 17:59 2018/8/8
 * To change this template use File | Settings | File Templates.
 */
public class ParamCheckTool {

    private static Validator validator;

    private static final LoggerAdapter LOGGER;

    private ParamCheckTool() {
    }

    public static void validatorBean(Object validatorobj, Class... groups) throws ParamCheckException {
        if (validatorobj == null) {
            throw new ParamCheckException(CommonErrorCode.COMMON_001.getCode(), CommonErrorCode.COMMON_001.getMsg());
        } else {
            Set<ConstraintViolation<Object>> constraintViolations = validator.validate(validatorobj, groups);
            LOGGER.debug("validator object over");
            if (!constraintViolations.isEmpty()) {
                Iterator<ConstraintViolation<Object>> it = constraintViolations.iterator();
                StringBuilder sb = new StringBuilder();

                while(it.hasNext()) {
                    sb.append(((ConstraintViolation)it.next()).getMessage());
                    sb.append(",");
                }
                String msg = sb.substring(0, sb.lastIndexOf(",")).toString();
                LOGGER.info("validator obj has errors,message is: [{}]", new Object[]{msg});
                throw new ParamCheckException(CommonErrorCode.COMMON_001.getCode(), CommonErrorCode.COMMON_001.getMsg() + msg);
            }
        }
    }

    private static synchronized void loadValidatorInstance() {
        if (validator == null) {
            LOGGER.debug("validator begin to load instance");
            validator = Validation.buildDefaultValidatorFactory().getValidator();
            LOGGER.debug("validator load instance over");
        }

    }

    static {
        LOGGER = LoggerAdapterFactory.getLogger(CommonLogType.SYS_BIZ.getLogName());
        loadValidatorInstance();
    }


}
