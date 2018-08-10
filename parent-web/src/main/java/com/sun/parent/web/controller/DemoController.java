package com.sun.parent.web.controller;

import com.sun.parent.facade.DemoFacade;
import com.sun.parent.facade.bean.TestDemoRequest;
import com.sun.parent.facade.bean.TestDemoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    @RequestMapping(value = "/testDemo",method = RequestMethod.POST,consumes = {"application/json;charset=UTF-8"})
    public TestDemoResponse testDemo(@RequestBody @Valid TestDemoRequest request){
        return demoFacade.testDemo(request);
    }


}
