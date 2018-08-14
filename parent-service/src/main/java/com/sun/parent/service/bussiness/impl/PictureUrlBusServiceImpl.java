package com.sun.parent.service.bussiness.impl;

import com.sun.parent.service.bussiness.PictureUrlBusService;
import com.sun.parent.service.repository.PictureUrlService;
import com.sun.parent.service.repository.bean.PictureUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.service.bussiness.impl.PictureUrlBusServiceImpl.java
 * @Date 10:10 2018/8/14
 * To change this template use File | Settings | File Templates.
 */
@Service("pictureUrlBusService")
public class PictureUrlBusServiceImpl implements PictureUrlBusService {

    @Autowired
    private PictureUrlService pictureUrlService;

    @Override
    public void insert(PictureUrl pictureUrl) {
        pictureUrlService.insert(pictureUrl);
    }

    @Override
    public List<PictureUrl> selectByAppId(Long appId) {
        return pictureUrlService.selectByAppId(appId);
    }
}
