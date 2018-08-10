package com.sun.parent.service.repository.impl;

import com.sun.parent.common.enums.CommonErrorCode;
import com.sun.parent.common.enums.CommonLogType;
import com.sun.parent.common.exception.dao.DBException;
import com.sun.parent.common.logger.LoggerAdapter;
import com.sun.parent.common.logger.LoggerAdapterFactory;
import com.sun.parent.common.utils.BeanCopierUtils;
import com.sun.parent.dao.mapper.GenresDOMapper;
import com.sun.parent.dao.model.GenresDO;
import com.sun.parent.service.repository.GenresService;
import com.sun.parent.service.repository.bean.Genres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.service.repository.impl.GenresServiceImpl.java
 * @Date 14:25 2018/8/10
 * To change this template use File | Settings | File Templates.
 */
@Service("genresService")
public class GenresServiceImpl implements GenresService {

    protected static final LoggerAdapter LOGGER = LoggerAdapterFactory.getLogger(CommonLogType.SYS_DAL.getLogName());

    @Autowired
    private GenresDOMapper genresDOMapper;

    @Override
    public void insert(Genres genres) {
        try {
            GenresDO genresdo = BeanCopierUtils.copyOne2One(genres,GenresDO.class);
            genresDOMapper.insert(genresdo);
        }catch (Exception e){
            LOGGER.error("GenresServiceImpl.insert({},{}) error,", genres,e);
            throw new DBException(CommonErrorCode.COMMON_200);
        }
    }
}
