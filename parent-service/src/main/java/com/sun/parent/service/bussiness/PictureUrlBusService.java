package com.sun.parent.service.bussiness;

import com.sun.parent.service.repository.bean.PictureUrl;

import java.util.List;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.service.bussiness.PictureUrlBusService.java
 * @Date 9:55 2018/8/14
 * To change this template use File | Settings | File Templates.
 */
public interface PictureUrlBusService {

    void insert(PictureUrl pictureUrl);

    List<PictureUrl> selectByAppId(Long appId);
}
