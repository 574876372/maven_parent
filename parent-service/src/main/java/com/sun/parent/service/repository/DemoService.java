package com.sun.parent.service.repository;

import com.sun.parent.common.exception.dao.DBException;
import com.sun.parent.service.repository.bean.Demo;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.service.repository.DemoService.java
 * @Date 16:48 2018/7/20
 * To change this template use File | Settings | File Templates.
 */
public interface DemoService {

    /**
     *
     * @param demo
     * @return
     */
    public Demo selectOne(Demo demo) throws DBException;

}
