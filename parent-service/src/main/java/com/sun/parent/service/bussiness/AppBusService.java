package com.sun.parent.service.bussiness;

import com.sun.parent.service.repository.bean.App;

import java.util.Date;
import java.util.List;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.service.bussiness.impl.AppBusService.java
 * @Date 18:21 2018/8/13
 * To change this template use File | Settings | File Templates.
 */
public interface AppBusService {

    /**
     * 写入一条数据
     * @param app
     * @return
     */
    Long insertReturnKey(App app);

    /**
     * 根据时间查询app信息
     * @param start
     * @param end
     * @return
     */
    List<App> selectByTime(Date start, Date end);
}
