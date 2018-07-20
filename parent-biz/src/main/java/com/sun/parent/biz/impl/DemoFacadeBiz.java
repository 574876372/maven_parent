package com.sun.parent.biz.impl;

import com.sun.parent.biz.action.DemoFacadeAction;
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

    @Autowired
    private DemoFacadeAction demoFacadeAction;

    @Override
    public String testDemo() {
        try {
            return demoFacadeAction.businessExecute();
        }catch (Exception e){
            throw e;
        }
    }
}
