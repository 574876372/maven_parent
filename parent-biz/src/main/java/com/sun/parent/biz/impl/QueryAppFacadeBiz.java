package com.sun.parent.biz.impl;

import com.sun.parent.biz.action.QueryAppFacadeAction;
import com.sun.parent.common.enums.APPCodeEnum;
import com.sun.parent.common.enums.CommonLogType;
import com.sun.parent.common.enums.CommonRespCode;
import com.sun.parent.common.exception.biz.BizException;
import com.sun.parent.common.logger.LoggerAdapter;
import com.sun.parent.common.logger.LoggerAdapterFactory;
import com.sun.parent.facade.QueryAppFacade;
import com.sun.parent.facade.bean.QueryAppRequest;
import com.sun.parent.facade.bean.QueryAppResponse;
import com.sun.parent.facade.bean.SynchronizeAppResponse;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.biz.impl.QueryAppFacadeBiz.java
 * @Date 11:34 2018/8/14
 * To change this template use File | Settings | File Templates.
 */
@Component("queryAppFacade")
public class QueryAppFacadeBiz implements QueryAppFacade {

    protected static final LoggerAdapter LOGGER = LoggerAdapterFactory.getLogger(CommonLogType.SYS_BIZ.getLogName());

    @Autowired
    private QueryAppFacadeAction queryAppFacadeAction;

    @Override
    public QueryAppResponse queryApp(QueryAppRequest request) {
        LOGGER.info("QueryAppFacadeBiz.queryApp queryApp param:[{}]", request);
        QueryAppResponse response = new QueryAppResponse();
        try {
            response = queryAppFacadeAction.sysApp(request);
        } catch (BizException e) {
            LOGGER.error("QueryAppFacadeBiz.queryApp BizException [{}] request=[{}]", e.getMessage(), ToStringBuilder.reflectionToString(request, ToStringStyle.SHORT_PREFIX_STYLE), e);
            response.setCode(e.getCode());
            response.setMsg(e.getMsg());
        } catch (Exception e) {
            LOGGER.error("QueryAppFacadeBiz.queryApp Exception  request=[{}]", ToStringBuilder.reflectionToString(request, ToStringStyle.SHORT_PREFIX_STYLE), e);
            response.setCode(CommonRespCode.RESP_999.getFullRespCode(APPCodeEnum.KPBF_CIP.sysId));
            response.setMsg(CommonRespCode.RESP_999.getDesc());
        }
        LOGGER.info("SynchronizeAppFacadeBiz.sysApp response:[{}]", response);
        return response;
    }
}
