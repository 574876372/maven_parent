package com.sun.parent.web.controller;

import com.sun.parent.facade.SynchronizeAppFacade;
import com.sun.parent.facade.bean.SynchronizeAppRequest;
import com.sun.parent.facade.bean.SynchronizeAppResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.web.controller.SynchronizeAppController.java
 * @Date 14:56 2018/8/10
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/synchronizeApp")
public class SynchronizeAppController {

    @Autowired
    private SynchronizeAppFacade synchronizeAppFacade;

    @ResponseBody
    @RequestMapping(value = "/sysApp",method = RequestMethod.POST,consumes = {"application/json;charset=UTF-8"})
    public SynchronizeAppResponse testDemo(@RequestBody @Valid SynchronizeAppRequest request){
        return synchronizeAppFacade.sysApp(request);
    }

}
