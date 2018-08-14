package com.sun.parent.biz.action;

import com.sun.parent.biz.action.abs.AbstractAction;
import com.sun.parent.common.enums.APPCodeEnum;
import com.sun.parent.common.enums.CommonErrorCode;
import com.sun.parent.common.enums.CommonLogType;
import com.sun.parent.common.exception.base.CommonException;
import com.sun.parent.common.exception.base.CommonRuntimeException;
import com.sun.parent.common.exception.biz.BizException;
import com.sun.parent.common.exception.biz.BizExceptionHandler;
import com.sun.parent.common.exception.param.CheckException;
import com.sun.parent.common.logger.LoggerAdapter;
import com.sun.parent.common.logger.LoggerAdapterFactory;
import com.sun.parent.common.utils.BeanCopierUtils;
import com.sun.parent.common.utils.VeDate;
import com.sun.parent.facade.bean.AppInfo;
import com.sun.parent.facade.bean.QueryAppRequest;
import com.sun.parent.facade.bean.QueryAppResponse;
import com.sun.parent.service.bussiness.AppBusService;
import com.sun.parent.service.bussiness.PictureUrlBusService;
import com.sun.parent.service.repository.bean.App;
import com.sun.parent.service.repository.bean.PictureUrl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.biz.action.QueryAppFacadeAction.java
 * @Date 11:40 2018/8/14
 * To change this template use File | Settings | File Templates.
 */
@Component("queryAppFacadeAction")
public class QueryAppFacadeAction extends AbstractAction<QueryAppResponse,QueryAppRequest> {

    protected static final LoggerAdapter LOGGER = LoggerAdapterFactory.getLogger(CommonLogType.SYS_BIZ.getLogName());

    @Autowired
    private AppBusService appBusService;

    @Autowired
    private PictureUrlBusService pictureUrlBusService;


    public QueryAppResponse sysApp(QueryAppRequest request) throws BizException {
        QueryAppResponse response  = new QueryAppResponse();
        try {
            response = excute(request);
        }catch (CommonRuntimeException e) {
            BizExceptionHandler.commonRuntimeExceptionHandle(APPCodeEnum.KPRP_RCDBS, e);
        } catch (CommonException e) {
            BizExceptionHandler.commonExceptionHandle(APPCodeEnum.KPRP_RCDBS, e);
        }
        return response;
    }

    @Override
    public QueryAppResponse businessExecute(QueryAppRequest request, Map<String, Object> paramMap) throws CommonException {
        QueryAppResponse response = new QueryAppResponse();
        List<App>  appList  =appBusService.selectByTime(VeDate.StringToDate(request.getStartTime()),VeDate.StringToDate(request.getEndTime()));
        if(appList==null || appList.size()<=0){
            return  response;
        }
        List<AppInfo>  appInfoList = BeanCopierUtils.copyList2List(appList,AppInfo.class);
        for(AppInfo appInfo:appInfoList){
            List<PictureUrl>  listPictureUrl = pictureUrlBusService.selectByAppId(appInfo.getId());
            if(listPictureUrl!=null && listPictureUrl.size()>0){
                List<String> pictureUrlList = new ArrayList<>();
                for(PictureUrl pictureUrl:listPictureUrl){
                    pictureUrlList.add(pictureUrl.getUrl());
                }
                appInfo.setScreenShotUrlId(pictureUrlList);
            }
        }
        response.setAppInfoList(appInfoList);
        return response;
    }

    @Override
    public void after(QueryAppResponse response, QueryAppRequest requset, Map<String, Object> paramMap) throws CommonException {

    }

    @Override
    public void before(QueryAppRequest request, Map<String, Object> paramMap) throws CommonException {
        if(StringUtils.isBlank(request.getStartTime()) || StringUtils.isBlank(request.getEndTime())){
            LOGGER.info("请求参数有误：[{}]",request);
            throw new BizException(CommonErrorCode.COMMON_001);
        }

    }

    @Override
    public void checkBusRule(QueryAppRequest request, Map<String, Object> checkMap) throws CheckException {

    }
}
