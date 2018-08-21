package com.sun.parent.biz.action;

import com.sun.parent.biz.action.abs.AbstractAction;
import com.sun.parent.biz.action.abs.AbstractLockAction;
import com.sun.parent.common.enums.APPCodeEnum;
import com.sun.parent.common.exception.base.CommonException;
import com.sun.parent.common.exception.base.CommonRuntimeException;
import com.sun.parent.common.exception.biz.BizException;
import com.sun.parent.common.exception.biz.BizExceptionHandler;
import com.sun.parent.common.exception.param.CheckException;
import com.sun.parent.facade.bean.TestDemoRequest;
import com.sun.parent.facade.bean.TestDemoResponse;
import com.sun.parent.service.repository.DemoService;
import com.sun.parent.service.repository.bean.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.biz.action.DemoFacadeAction.java
 * @Date 16:35 2018/7/20
 * To change this template use File | Settings | File Templates.
 */
@Component("demoFacadeAction")
public class DemoFacadeAction extends AbstractLockAction<TestDemoResponse,TestDemoRequest> {


    @Autowired
    private DemoService demoService;

    public TestDemoResponse testDemo(TestDemoRequest request) throws BizException {
        TestDemoResponse response  = new TestDemoResponse();
        try {
            response = excute(request,null,null);
        }catch (CommonRuntimeException e) {
            BizExceptionHandler.commonRuntimeExceptionHandle(APPCodeEnum.KPRP_RCDBS, e);
        } catch (CommonException e) {
            BizExceptionHandler.commonExceptionHandle(APPCodeEnum.KPRP_RCDBS, e);
        }
        return response;
    }

    @Override
    public TestDemoResponse businessExecute(TestDemoRequest request, Map<String, Object> paramMap) throws CommonException {
        TestDemoResponse response = new TestDemoResponse();
        Demo demo = new Demo();
        demo.setId(Long.valueOf(request.getId()));
        Demo demoResult = demoService.selectOne(demo);
        response.setName(demoResult.getName());
        return  response;
    }

    @Override
    public void after(TestDemoResponse response, TestDemoRequest requset, Map<String, Object> paramMap) throws CommonException {

    }

    @Override
    public void before(TestDemoRequest request, Map<String, Object> paramMap) throws CommonException {

    }

    @Override
    public void checkBusRule(TestDemoRequest request, Map<String, Object> checkMap) throws CheckException {

    }
}
