package com.sun.parent.biz.impl;

import com.sun.parent.biz.action.SynchronizeAppFacadeAction;
import com.sun.parent.common.enums.APPCodeEnum;
import com.sun.parent.common.enums.CommonLogType;
import com.sun.parent.common.enums.CommonRespCode;
import com.sun.parent.common.exception.biz.BizException;
import com.sun.parent.common.logger.LoggerAdapter;
import com.sun.parent.common.logger.LoggerAdapterFactory;
import com.sun.parent.facade.SynchronizeAppFacade;
import com.sun.parent.facade.bean.SynchronizeAppRequest;
import com.sun.parent.facade.bean.SynchronizeAppResponse;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.biz.impl.SynchronizeAppFacadeBiz.java
 * @Date 15:03 2018/8/10
 * To change this template use File | Settings | File Templates.
 */
@Component("synchronizeAppFacade")
public class SynchronizeAppFacadeBiz implements SynchronizeAppFacade {

    protected static final LoggerAdapter LOGGER = LoggerAdapterFactory.getLogger(CommonLogType.SYS_BIZ.getLogName());

    @Autowired
    private SynchronizeAppFacadeAction synchronizeAppFacadeAction;

    @Override
    public SynchronizeAppResponse sysApp(SynchronizeAppRequest request) {
        LOGGER.info("SynchronizeAppFacadeBiz.sysApp start param:[{}]",request);
        SynchronizeAppResponse response = new SynchronizeAppResponse();
        try {
            response = synchronizeAppFacadeAction.sysApp(request);
        }catch (BizException e){
            LOGGER.error("SynchronizeAppFacadeBiz.sysApp BizException [{}] request=[{}]", e.getMessage(), ToStringBuilder.reflectionToString(request, ToStringStyle.SHORT_PREFIX_STYLE), e);
            response.setCode(e.getCode());
            response.setMsg(e.getMsg());
        }catch (Exception e){
            LOGGER.error("SynchronizeAppFacadeBiz.sysApp Exception  request=[{}]", ToStringBuilder.reflectionToString(request, ToStringStyle.SHORT_PREFIX_STYLE), e);
            response.setCode(CommonRespCode.RESP_999.getFullRespCode(APPCodeEnum.KPBF_CIP.sysId));
            response.setMsg(CommonRespCode.RESP_999.getDesc());
        }
        LOGGER.info("SynchronizeAppFacadeBiz.sysApp response:[{}]",response);
        return  response;
    }
}
