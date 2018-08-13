package com.sun.parent.biz.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.sun.parent.biz.action.abs.AbstractAction;
import com.sun.parent.common.bean.json.JsonRootBean;
import com.sun.parent.common.bean.json.Results;
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
import com.sun.parent.common.utils.HttpsUtil;
import com.sun.parent.facade.bean.SynchronizeAppRequest;
import com.sun.parent.facade.bean.SynchronizeAppResponse;
import com.sun.parent.service.repository.bean.App;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.biz.action.SynchronizeAppFacadeAction.java
 * @Date 15:07 2018/8/10
 * To change this template use File | Settings | File Templates.
 */
@Component("synchronizeAppFacadeAction")
public class SynchronizeAppFacadeAction  extends AbstractAction<SynchronizeAppResponse,SynchronizeAppRequest> {

    protected static final LoggerAdapter LOGGER = LoggerAdapterFactory.getLogger(CommonLogType.SYS_BIZ.getLogName());


    public SynchronizeAppResponse sysApp(SynchronizeAppRequest request) throws BizException {
        SynchronizeAppResponse response  = new SynchronizeAppResponse();
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
    public SynchronizeAppResponse businessExecute(SynchronizeAppRequest request, Map<String, Object> paramMap) throws CommonException {
       String contant  =  HttpsUtil.sendHttps(request.getAppUrl());
       if(StringUtils.isBlank(contant)){
           LOGGER.info("请求appURL返回空数据");
           throw new BizException(CommonErrorCode.COMMON_304);
       }
       JsonRootBean jsonRootBean = readJSON(contant);
      // Long feedId = saveFeedBus(jsonRootBean);
//       if(feedId==null){
//           LOGGER.info("写入feed表异常");
//           throw new BizException(CommonErrorCode.COMMON_304);
//       }
//       saveAppBus(feedId,jsonRootBean);
       SynchronizeAppResponse response = new SynchronizeAppResponse();
       response.setCode(CommonErrorCode.COMMON_000000.getCode());
       response.setCode(CommonErrorCode.COMMON_000000.getMsg());
       return response;
    }

    private Long saveAppInfo(JsonRootBean jsonRootBean){
        App app = new App();
        if(jsonRootBean!=null &&  jsonRootBean.getResults()!=null && jsonRootBean.getResults().size()>0){
            for(Results results :jsonRootBean.getResults()){
             //app.setScreenShotUrlId(results.getScreenshotUrls());
               // app.setIpadScreenShotUrlId();
               // app.setAppleTvScreenShotUrlId();
                app.setArtWorkUrl512(results.getArtworkUrl512());
                app.setArtistViewUrl(results.getArtistViewUrl());
                app.setArtWorkUrl60(results.getArtworkUrl60());
                app.setArtWorkUrl100(results.getArtworkUrl100());
                //app.setSupportedDevices();
                app.setKind(results.getKind());
               // app.setFeatures(results.getFeatures());
                //app.setAdvisories(results.getAdvisories());
                app.setGameCenterEnabled(results.getIsGameCenterEnabled());

            }
        }
     return null;
    }


    /**
     * 返回json对象转 对象
     * @param contant
     * @return
     * @throws BizException
     */
    public JsonRootBean readJSON(String contant) throws BizException{
        JsonRootBean jsonRootBean = JSON.parseObject(contant, new TypeReference<JsonRootBean>() {});
        return jsonRootBean;
    }

    @Override
    public void after(SynchronizeAppResponse response, SynchronizeAppRequest requset, Map<String, Object> paramMap) throws CommonException {

    }

    @Override
    public void before(SynchronizeAppRequest request, Map<String, Object> paramMap) throws CommonException {
        if(StringUtils.isBlank(request.getAppUrl())){
            throw new BizException(CommonErrorCode.COMMON_001);
        }
    }

    @Override
    public void checkBusRule(SynchronizeAppRequest request, Map<String, Object> checkMap) throws CheckException {

    }
}
