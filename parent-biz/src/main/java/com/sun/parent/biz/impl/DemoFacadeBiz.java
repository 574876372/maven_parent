package com.sun.parent.biz.impl;

import com.sun.parent.biz.action.DemoFacadeAction;
import com.sun.parent.common.enums.CommonLogType;
import com.sun.parent.common.exception.biz.BizException;
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
    protected static final LoggerAdapter LOGGER = LoggerAdapterFactory.getLogger(CommonLogType.SYS_BIZ.getLogName());
    @Autowired
    private DemoFacadeAction demoFacadeAction;

    @Override
    public String testDemo() {
        LOGGER.info("DemoFacadeBiz.testDemo start");
        String result ="";
        try {
            result = demoFacadeAction.excute();
        }catch (BizException e){


        }catch (Exception e){

        }
        LOGGER.info("DemoFacadeBiz.testDemo response:[{}]",result);
        return  result;
    }
}
