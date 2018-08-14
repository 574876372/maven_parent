package com.sun.parent.dao.mapper;

import com.sun.parent.dao.model.AppDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Date;
import java.util.List;


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

    Long insertReturnKey(AppDO record);

    List<AppDO> selectByTime(@Param("start") Date start, @Param("end")Date end);
}