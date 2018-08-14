package com.sun.parent.service.bussiness.impl;

import com.sun.parent.service.bussiness.AppBusService;
import com.sun.parent.service.repository.AppService;
import com.sun.parent.service.repository.bean.App;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.service.bussiness.impl.AppBusServiceImpl.java
 * @Date 18:22 2018/8/13
 * To change this template use File | Settings | File Templates.
 */
@Service("appBusService")
public class AppBusServiceImpl implements AppBusService {

    @Autowired
    private AppService appService;

    @Override
    public Long insertReturnKey(App app) {
        return appService.insertReturnKey(app);
    }

    @Override
    public List<App> selectByTime(Date start, Date end) {
        return appService.selectByTime(start,end);
    }
}
