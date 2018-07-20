package com.sun.parent.web.controller;

import com.sun.parent.facade.DemoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:ChenLei
 * @Description: com.sun.DemoWeb.java
 * @Date 17:34 2018/7/18
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoFacade demoFacade;

    @ResponseBody
    @RequestMapping(value = "/testDemo",method = RequestMethod.GET)
    public String testDemo(){

        return demoFacade.testDemo();
    }
}
