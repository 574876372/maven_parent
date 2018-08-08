package com.sun.parent.biz.action;

import com.sun.parent.common.enums.APPCodeEnum;
import com.sun.parent.common.exception.base.CommonException;
import com.sun.parent.common.exception.base.CommonRuntimeException;
import com.sun.parent.common.exception.biz.BizException;
import com.sun.parent.common.exception.biz.BizExceptionHandler;
import com.sun.parent.common.exception.dao.DBException;
import com.sun.parent.facade.bean.TestDemoRequest;
import com.sun.parent.facade.bean.TestDemoResponse;
import com.sun.parent.service.repository.DemoService;
import com.sun.parent.service.repository.bean.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.biz.action.DemoFacadeAction.java
 * @Date 16:35 2018/7/20
 * To change this template use File | Settings | File Templates.
 */
@Component("demoFacadeAction")
public class DemoFacadeAction {


    @Autowired
    private DemoService demoService;

    public TestDemoResponse excute(TestDemoRequest request) throws BizException {
        TestDemoResponse response  = new TestDemoResponse();
        try {
            response = businessExecute(request);
        }catch (CommonRuntimeException e) {
            BizExceptionHandler.commonRuntimeExceptionHandle(APPCodeEnum.KPRP_RCDBS, e);
        } catch (CommonException e) {
            BizExceptionHandler.commonExceptionHandle(APPCodeEnum.KPRP_RCDBS, e);
        }
        return response;
    }

    public TestDemoResponse businessExecute(TestDemoRequest request) throws CommonException,CommonRuntimeException{
        TestDemoResponse response = new TestDemoResponse();
        Demo demo = new Demo();
        demo.setId(Long.valueOf(request.getId()));
        Demo demoResult = demoService.selectOne(demo);
        response.setName(demoResult.getName());
        return  response;
    }


}
