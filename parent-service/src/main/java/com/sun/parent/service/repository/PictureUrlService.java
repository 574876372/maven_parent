package com.sun.parent.service.repository;

import com.sun.parent.service.repository.bean.PictureUrl;

import java.util.List;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.service.repository.PictureUrlService.java
 * @Date 9:48 2018/8/14
 * To change this template use File | Settings | File Templates.
 */
public interface PictureUrlService {

    void insert(PictureUrl pictureUrl);


    List<PictureUrl> selectByAppId(Long appId);
}
