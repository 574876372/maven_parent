package com.sun.parent.service.repository.impl;

import com.sun.parent.common.enums.CommonErrorCode;
import com.sun.parent.common.enums.CommonLogType;
import com.sun.parent.common.exception.dao.DBException;
import com.sun.parent.common.logger.LoggerAdapter;
import com.sun.parent.common.logger.LoggerAdapterFactory;
import com.sun.parent.common.utils.BeanCopierUtils;
import com.sun.parent.dao.mapper.AppDOMapper;
import com.sun.parent.dao.model.AppDO;
import com.sun.parent.service.repository.AppService;
import com.sun.parent.service.repository.bean.App;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.service.repository.impl.AppServiceImpl.java
 * @Date 18:20 2018/8/13
 * To change this template use File | Settings | File Templates.
 */
@Service("appService")
public class AppServiceImpl implements AppService {

    protected static final LoggerAdapter LOGGER = LoggerAdapterFactory.getLogger(CommonLogType.SYS_DAL.getLogName());

    @Autowired
    private AppDOMapper appDOMapper;


    @Override
    public Long insertReturnKey(App app) {
        Long result = null;
        try {
            AppDO  appDo = BeanCopierUtils.copyOne2One(app,AppDO.class);
            appDOMapper.insertReturnKey(appDo);
            result = appDo.getId();
        }catch (Exception e){
            LOGGER.error("AppService.insertReturnKey param:[{}],Exception:[{}]",app,e);
            throw new DBException(CommonErrorCode.COMMON_200,e);
        }
        return result;
    }

    @Override
    public List<App> selectByTime(Date start, Date end) {
        List<App> resultList = null;
        try {
            List<AppDO> appDoList =  appDOMapper.selectByTime(start,end);
            if(appDoList!=null){
                resultList = BeanCopierUtils.copyList2List(appDoList,App.class);
            }
        }catch (Exception e){
            LOGGER.error("AppService.insertReturnKey param:[{}],[{}],Exception:[{}]",start,end,e);
            throw new DBException(CommonErrorCode.COMMON_200,e);
        }
        return resultList;
    }
}
