package com.sun.parent.service.bussiness.impl;

import com.sun.parent.service.bussiness.GenresBusService;
import com.sun.parent.service.repository.GenresService;
import com.sun.parent.service.repository.bean.Genres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.service.bussiness.impl.GenresBusServiceImpl.java
 * @Date 14:52 2018/8/10
 * To change this template use File | Settings | File Templates.
 */
@Service("genresBusService")
public class GenresBusServiceImpl implements GenresBusService {

    @Autowired
    private GenresService genresService;

    @Override
    public void insert(Genres genres) {
        genresService.insert(genres);
    }
}
