package com.sun.parent.biz.impl;

import com.sun.parent.biz.action.DemoFacadeAction;
import com.sun.parent.common.enums.CommonLogType;
import com.sun.parent.common.logger.LoggerAdapter;
import com.sun.parent.common.logger.LoggerAdapterFactory;
import com.sun.parent.facade.DemoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.biz.impl.DemoFacadeBiz.java
 * @Date 15:59 2018/7/20
 * To change this template use File | Settings | File Templates.
 */
@Component("demoFacade")
public class DemoFacadeBiz implements DemoFacade {

    protected static final LoggerAdapter LOGGER1 = LoggerAdapterFactory.getLogger(CommonLogType.SYS_CONTROLLER.getLogName());
    protected static final LoggerAdapter LOGGER = LoggerAdapterFactory.getLogger(CommonLogType.SYS_BIZ.getLogName());
    protected static final LoggerAdapter LOGGER2 = LoggerAdapterFactory.getLogger(CommonLogType.SYS_DAL.getLogName());
    protected static final LoggerAdapter LOGGER3 = LoggerAdapterFactory.getLogger(CommonLogType.SYS_COMMON.getLogName());
    protected static final LoggerAdapter LOGGER4 = LoggerAdapterFactory.getLogger(CommonLogType.SYS_INTEGRATION.getLogName());
    protected static final LoggerAdapter LOGGER5 = LoggerAdapterFactory.getLogger(CommonLogType.SYS_SERVICE.getLogName());

    @Autowired
    private DemoFacadeAction demoFacadeAction;

    @Override
    public String testDemo() {
        LOGGER.info("DemoFacadeBiz.testDemo start");
        LOGGER1.info("SYS_CONTROLLER");
        LOGGER2.info("SYS_DAL");
        LOGGER3.info("SYS_COMMON");
        LOGGER4.info("SYS_INTEGRATION");
        LOGGER5.info("SYS_SERVICE");
        String result ="";
        try {
            result = demoFacadeAction.businessExecute();
        }catch (Exception e){
            throw e;
        }
        LOGGER.info("DemoFacadeBiz.testDemo response:[{}]",result);
        return  result;
    }
}
