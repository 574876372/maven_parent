package com.sun.parent.facade;

import com.sun.parent.facade.bean.QueryAppRequest;
import com.sun.parent.facade.bean.QueryAppResponse;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.facade.QueryAppFacade.java
 * @Date 11:27 2018/8/14
 * To change this template use File | Settings | File Templates.
 */
public interface QueryAppFacade {

    public QueryAppResponse queryApp(QueryAppRequest request);
}
