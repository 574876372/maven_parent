package com.sun.parent.dao.mapper;

import com.sun.parent.dao.model.PictureUrlDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;


@BaseParentDB
@Qualifier("pictureUrlDOMapper")
public interface PictureUrlDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(PictureUrlDO record);

    int insertSelective(PictureUrlDO record);

    PictureUrlDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PictureUrlDO record);

    int updateByPrimaryKey(PictureUrlDO record);

    List<PictureUrlDO> selectByAppId(@Param("appId") Long appId);
}