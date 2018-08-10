package com.sun.parent.facade;

import com.sun.parent.facade.bean.SynchronizeAppRequest;
import com.sun.parent.facade.bean.SynchronizeAppResponse;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.facade.SynchronizeAppFacade.java
 * @Date 14:57 2018/8/10
 * To change this template use File | Settings | File Templates.
 */
public interface SynchronizeAppFacade {

    public SynchronizeAppResponse sysApp(SynchronizeAppRequest request);
}
