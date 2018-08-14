package com.sun.parent.service.repository;

import com.sun.parent.service.repository.bean.App;

import java.util.Date;
import java.util.List;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.service.repository.AppService.java
 * @Date 18:19 2018/8/13
 * To change this template use File | Settings | File Templates.
 */
public interface AppService {

    /**
     * 写入一条数据
     * @param app
     * @return
     */
    Long insertReturnKey(App app);


    List<App> selectByTime(Date start,Date end);
}
