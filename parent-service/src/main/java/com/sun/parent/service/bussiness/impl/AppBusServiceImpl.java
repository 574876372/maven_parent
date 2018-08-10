package com.sun.parent.service.bussiness.impl;

import com.sun.parent.service.bussiness.AppBusService;
import com.sun.parent.service.repository.AppService;
import com.sun.parent.service.repository.bean.App;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.service.bussiness.impl.AppBusServiceImpl.java
 * @Date 14:50 2018/8/10
 * To change this template use File | Settings | File Templates.
 */
@Service("appBusService")
public class AppBusServiceImpl implements AppBusService {

    @Autowired
    private AppService appService;

    @Override
    public void insert(App app) {
        appService.insert(app);
    }

    @Override
    public void insert(List<App> apps) {
        for(App app:apps){
            appService.insert(app);
        }
    }
}
