package com.sun.parent.web.controller;

import com.sun.parent.facade.QueryAppFacade;
import com.sun.parent.facade.bean.QueryAppRequest;
import com.sun.parent.facade.bean.QueryAppResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.web.controller.QueryAppController.java
 * @Date 11:23 2018/8/14
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/query")
public class QueryAppController {

    @Autowired
    private QueryAppFacade queryAppFacade;

    @ResponseBody
    @RequestMapping(value = "/app",method = RequestMethod.POST,consumes = {"application/json;charset=UTF-8"})
    public QueryAppResponse testDemo(@RequestBody @Valid QueryAppRequest request){
        return queryAppFacade.queryApp(request);
    }

}
