package com.sun.parent.service.bussiness;

import com.sun.parent.service.repository.bean.App;

import java.util.List;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.service.repository.bussiness.AppBusService.java
 * @Date 14:49 2018/8/10
 * To change this template use File | Settings | File Templates.
 */
public interface AppBusService {

    public void insert(App app);

    public void insert(List<App> app);
}
