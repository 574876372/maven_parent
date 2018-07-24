package com.sun.parent.biz.action;

import com.sun.parent.service.repository.DemoService;
import com.sun.parent.service.repository.bean.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.biz.action.DemoFacadeAction.java
 * @Date 16:35 2018/7/20
 * To change this template use File | Settings | File Templates.
 */
@Component("demoFacadeAction")
public class DemoFacadeAction {


    @Autowired
    private DemoService demoService;

    public String businessExecute(){
        Demo demo = new Demo();
        demo.setId(1l);
        Demo result = demoService.selectOne(demo);
        return  result.getName();
    }


}
