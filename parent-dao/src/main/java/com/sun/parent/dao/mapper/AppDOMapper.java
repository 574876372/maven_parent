package com.sun.parent.dao.mapper;

import com.sun.parent.dao.model.AppDO;
import org.springframework.beans.factory.annotation.Qualifier;


@BaseParentDB
@Qualifier("appDOMapper")
public interface AppDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(AppDO record);

    int insertSelective(AppDO record);

    AppDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppDO record);

    int updateByPrimaryKeyWithBLOBs(AppDO record);

    int updateByPrimaryKey(AppDO record);
}