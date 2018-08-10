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

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.service.repository.impl.AppServiceImpl.java
 * @Date 14:24 2018/8/10
 * To change this template use File | Settings | File Templates.
 */
@Service("appService")
public class AppServiceImpl implements AppService {

    protected static final LoggerAdapter LOGGER = LoggerAdapterFactory.getLogger(CommonLogType.SYS_DAL.getLogName());

    @Autowired
    private AppDOMapper appDOMapper;


    @Override
    public void insert(App app) {
        try {
            AppDO appdo = BeanCopierUtils.copyOne2One(app,AppDO.class);
            appDOMapper.insert(appdo);
            LOGGER.info("");
        }catch (Exception e){
            LOGGER.error("AppServiceImpl.insert({},{}) error,", app,e);
            throw new DBException(CommonErrorCode.COMMON_200);
        }
    }
}
