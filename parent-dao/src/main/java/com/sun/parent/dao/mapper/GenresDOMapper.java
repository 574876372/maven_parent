package com.sun.parent.dao.mapper;

import com.sun.parent.dao.model.GenresDO;
import org.springframework.beans.factory.annotation.Qualifier;

@BaseParentDB
@Qualifier("genresDOMapper")
public interface GenresDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GenresDO record);

    int insertSelective(GenresDO record);

    GenresDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GenresDO record);

    int updateByPrimaryKey(GenresDO record);
}