package com.sun.parent.biz.impl;

import com.sun.parent.biz.action.DemoFacadeAction;
import com.sun.parent.common.enums.APPCodeEnum;
import com.sun.parent.common.enums.CommonErrorCode;
import com.sun.parent.common.enums.CommonLogType;
import com.sun.parent.common.enums.CommonRespCode;
import com.sun.parent.common.exception.biz.BizException;
import com.sun.parent.common.logger.LoggerAdapter;
import com.sun.parent.common.logger.LoggerAdapterFactory;
import com.sun.parent.facade.DemoFacade;
import com.sun.parent.facade.bean.TestDemoRequest;
import com.sun.parent.facade.bean.TestDemoResponse;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.biz.impl.DemoFacadeBiz.java
 * @Date 15:59 2018/7/20
 * To change this template use File | Settings | File Templates.
 */
@Component("demoFacade")
public class DemoFacadeBiz implements DemoFacade {
    protected static final LoggerAdapter LOGGER = LoggerAdapterFactory.getLogger(CommonLogType.SYS_BIZ.getLogName());
    @Autowired
    private DemoFacadeAction demoFacadeAction;

    @Override
    public TestDemoResponse testDemo(TestDemoRequest request) {
        LOGGER.info("DemoFacadeBiz.testDemo start param:[{}]",request);
        TestDemoResponse response = new TestDemoResponse();
        try {
            response = demoFacadeAction.excute(request);
        }catch (BizException e){
            LOGGER.error("DemoFacadeBiz.testDemo BizException [{}] request=[{}]", e.getMessage(), ToStringBuilder.reflectionToString(request, ToStringStyle.SHORT_PREFIX_STYLE), e);
            response.setCode(e.getCode());
            response.setMsg(e.getMsg());
        }catch (Exception e){
            LOGGER.error("DemoFacadeBiz.testDemo Exception  request=[{}]", ToStringBuilder.reflectionToString(request, ToStringStyle.SHORT_PREFIX_STYLE), e);
            response.setCode(CommonRespCode.RESP_999.getFullRespCode(APPCodeEnum.KPBF_CIP.sysId));
            response.setMsg(CommonRespCode.RESP_999.getDesc());
        }
        LOGGER.info("DemoFacadeBiz.testDemo response:[{}]",response);
        return  response;
    }
}
