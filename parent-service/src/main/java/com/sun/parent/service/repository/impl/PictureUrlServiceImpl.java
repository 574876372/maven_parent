package com.sun.parent.service.repository.impl;

import com.sun.parent.common.enums.CommonErrorCode;
import com.sun.parent.common.enums.CommonLogType;
import com.sun.parent.common.exception.dao.DBException;
import com.sun.parent.common.logger.LoggerAdapter;
import com.sun.parent.common.logger.LoggerAdapterFactory;
import com.sun.parent.common.utils.BeanCopierUtils;
import com.sun.parent.dao.mapper.PictureUrlDOMapper;
import com.sun.parent.dao.model.PictureUrlDO;
import com.sun.parent.service.repository.PictureUrlService;
import com.sun.parent.service.repository.bean.PictureUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.service.repository.impl.PictureUrlServiceImpl.java
 * @Date 9:49 2018/8/14
 * To change this template use File | Settings | File Templates.
 */
@Service("pictureUrlService")
public class PictureUrlServiceImpl implements PictureUrlService {

    protected static final LoggerAdapter LOGGER = LoggerAdapterFactory.getLogger(CommonLogType.SYS_DAL.getLogName());

    @Autowired
    private PictureUrlDOMapper pictureUrlDOMapper;


    @Override
    public void insert(PictureUrl pictureUrl) {
        try {
            PictureUrlDO pictureUrlDO = BeanCopierUtils.copyOne2One(pictureUrl,PictureUrlDO.class);
            pictureUrlDOMapper.insert(pictureUrlDO);
        }catch (Exception e){
            LOGGER.error("PictureUrlService.insert param:[{}],Exception:[{}]",pictureUrl,e);
            throw new DBException(CommonErrorCode.COMMON_200,e);
        }
    }

    @Override
    public List<PictureUrl> selectByAppId(Long appId) {
        List<PictureUrl> resultList = null;
        try {
            List<PictureUrlDO> pictureUrlDOList =  pictureUrlDOMapper.selectByAppId(appId);
            if(pictureUrlDOList!=null && pictureUrlDOList.size()>0){
                resultList = BeanCopierUtils.copyList2List(pictureUrlDOList,PictureUrl.class);
            }
        }catch (Exception e){
            LOGGER.error("PictureUrlService.insert param:[{}],Exception:[{}]",appId,e);
            throw new DBException(CommonErrorCode.COMMON_200,e);
        }
        return resultList;
    }
}
