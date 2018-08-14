package com.sun.parent.dao.mapper;

import com.sun.parent.dao.model.DemoDO;
import org.springframework.beans.factory.annotation.Qualifier;

@BaseParentDB
@Qualifier("demoDOMapper")
public interface DemoDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(DemoDO record);

    int insertSelective(DemoDO record);

    DemoDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DemoDO record);

    int updateByPrimaryKey(DemoDO record);

    DemoDO selectOne(DemoDO demoDo);


}