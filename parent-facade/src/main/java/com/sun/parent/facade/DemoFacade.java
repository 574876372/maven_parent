package com.sun.parent.facade;

import com.sun.parent.facade.bean.TestDemoRequest;
import com.sun.parent.facade.bean.TestDemoResponse;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.facade.DemoFacade.java
 * @Date 15:57 2018/7/20
 * To change this template use File | Settings | File Templates.
 */
public interface DemoFacade {

    public TestDemoResponse testDemo(TestDemoRequest request);
}
