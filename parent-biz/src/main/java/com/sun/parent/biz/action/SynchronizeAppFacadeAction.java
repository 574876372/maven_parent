package com.sun.parent.biz.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.sun.parent.biz.action.abs.AbstractAction;
import com.sun.parent.common.bean.json.JsonRootBean;
import com.sun.parent.common.bean.json.Results;
import com.sun.parent.common.enums.APPCodeEnum;
import com.sun.parent.common.enums.CommonErrorCode;
import com.sun.parent.common.enums.CommonLogType;
import com.sun.parent.common.enums.PictureTypeEnum;
import com.sun.parent.common.exception.base.CommonException;
import com.sun.parent.common.exception.base.CommonRuntimeException;
import com.sun.parent.common.exception.base.IErrorCode;
import com.sun.parent.common.exception.biz.BizException;
import com.sun.parent.common.exception.biz.BizExceptionHandler;
import com.sun.parent.common.exception.param.CheckException;
import com.sun.parent.common.logger.LoggerAdapter;
import com.sun.parent.common.logger.LoggerAdapterFactory;
import com.sun.parent.common.utils.HttpsUtil;
import com.sun.parent.facade.bean.SynchronizeAppRequest;
import com.sun.parent.facade.bean.SynchronizeAppResponse;
import com.sun.parent.service.bussiness.AppBusService;
import com.sun.parent.service.bussiness.PictureUrlBusService;
import com.sun.parent.service.repository.bean.App;
import com.sun.parent.service.repository.bean.PictureUrl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

    @Autowired
    private AppBusService appBusService;

    @Autowired
    private PictureUrlBusService pictureUrlBusService;


    public SynchronizeAppResponse sysApp(SynchronizeAppRequest request) throws BizException {
        SynchronizeAppResponse response  = new SynchronizeAppResponse();
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
    public SynchronizeAppResponse businessExecute(SynchronizeAppRequest request, Map<String, Object> paramMap) throws CommonException {
       String contant  =  HttpsUtil.sendHttps(request.getAppUrl());
       if(StringUtils.isBlank(contant)){
           LOGGER.info("请求appURL返回空数据");
           throw new BizException(CommonErrorCode.COMMON_304);
       }
       JsonRootBean jsonRootBean = readJSON(contant);

       //保存app信息
       Long idKey = saveAppInfo(jsonRootBean);

       //保存图片地址
        List<PictureUrl> pictureUrlList = buildPictureUrlList(jsonRootBean,idKey);
        for(PictureUrl pictureUrl:pictureUrlList){
            pictureUrlBusService.insert(pictureUrl);
        }

       SynchronizeAppResponse response = new SynchronizeAppResponse();
       response.setCode(CommonErrorCode.COMMON_000000.getCode());
       response.setCode(CommonErrorCode.COMMON_000000.getMsg());
       return response;
    }


    /**
     * 组装对象
     * @return
     */
    private List<PictureUrl> buildPictureUrlList(JsonRootBean jsonRootBean,Long appIdKey){
        List<PictureUrl> listPictureUrl = new ArrayList<>();
        if(jsonRootBean!=null && jsonRootBean.getResults()!=null && jsonRootBean.getResults().size()==1){
            List<String> screenshotUrls  = jsonRootBean.getResults().get(0).getScreenshotUrls();
            Date date = new Date();
            for(String screenshotUrl:screenshotUrls){
                PictureUrl pictureUrl = new PictureUrl();
                pictureUrl.setAppId(appIdKey);
                pictureUrl.setType(PictureTypeEnum.PIC_TYPE_1.getType());
                pictureUrl.setUrl(screenshotUrl);
                pictureUrl.setCreateTime(date);
                pictureUrl.setUpdateTime(date);
                listPictureUrl.add(pictureUrl);
            }
        }
       return listPictureUrl;
    }

    private Long saveAppInfo(JsonRootBean jsonRootBean) throws BizException{
        Long idKey =null;
        if(jsonRootBean!=null &&  jsonRootBean.getResults()!=null && jsonRootBean.getResults().size()>0 && jsonRootBean.getResults().size()==1){
            for(Results results :jsonRootBean.getResults()){
                App app = new App();
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
                app.setAverageUserRatingForCurrentversion(String.valueOf(results.getAverageUserRatingForCurrentVersion()));
                app.setLanguageCodesIso2a(results.getLanguageCodesISO2A().toString());
                app.setFileSizeBytes(results.getFileSizeBytes());
                app.setUserRatingCountForCurrentVersion(String.valueOf(results.getUserRatingCountForCurrentVersion()));
                app.setTrackContentRating(results.getTrackContentRating());
                app.setContentAdvisoryRating(results.getContentAdvisoryRating());
                app.setTrackViewUrl(results.getTrackViewUrl());
                app.setTrackCensoredName(results.getTrackCensoredName());
                app.setIsVppDeviceBasedLicensingEnabled(String.valueOf(results.getIsVppDeviceBasedLicensingEnabled()));
                app.setSellerName(results.getSellerName());
                app.setReleaseDate(results.getReleaseDate());
                app.setTrackId(String.valueOf(results.getTrackId()));
                app.setTrackName(results.getTrackName());
                app.setPrimaryGenreName(results.getPrimaryGenreName());
                app.setPrimaryGenreId(String.valueOf(results.getPrimaryGenreId()));
                app.setCurrency(results.getCurrency());
                app.setWrapperType(results.getWrapperType());
                app.setVersion(results.getVersion());
                app.setArtistId(String.valueOf(results.getArtistId()));
                app.setArtistName(results.getArtistName());
                app.setPrice(Long.valueOf(results.getPrice()));
                app.setBundleId(results.getBundleId());
                app.setReleaseNotes(results.getReleaseNotes());
                app.setCurrentVersionReleaseDate(results.getCurrentVersionReleaseDate());
                app.setMinimumOsVersion(results.getMinimumOsVersion());
                app.setFormattedPrice(results.getFormattedPrice());
                app.setAverageUserRating(String.valueOf(results.getAverageUserRating()));
                app.setUserRatingCount(String.valueOf(results.getUserRatingCount()));
                app.setDescription(results.getDescription());
                Date date = new Date();
                app.setUpdateTime(date);
                app.setCreateTime(date);
                idKey =  appBusService.insertReturnKey(app);
            }
        }else {
            LOGGER.info("查询app应用数据大于一条");
            throw new BizException(CommonErrorCode.COMMON_001);
        }
     return idKey;
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
