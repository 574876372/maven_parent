package com.sun.parent.service.repository.impl;

import com.sun.parent.common.enums.CommonErrorCode;
import com.sun.parent.common.exception.dao.DBException;
import com.sun.parent.common.utils.BeanCopierUtils;
import com.sun.parent.dao.mapper.DemoDOMapper;
import com.sun.parent.dao.model.DemoDO;
import com.sun.parent.service.repository.DemoService;
import com.sun.parent.service.repository.bean.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.service.repository.impl.DemoServiceImpl.java
 * @Date 8:58 2018/7/24
 * To change this template use File | Settings | File Templates.
 */
@Service("demoService")
public class DemoServiceImpl implements DemoService{

    @Autowired
    private DemoDOMapper demoDOMapper;

    @Override
    public Demo selectOne(Demo demo) throws DBException{
        DemoDO demoDo = BeanCopierUtils.copyOne2One(demo,DemoDO.class);
        DemoDO demoDoResul =  null;
        try {
            demoDoResul = demoDOMapper.selectOne(demoDo);
        }catch (Exception e){
            throw new DBException(CommonErrorCode.COMMON_200);
        }
        if(demoDoResul==null){
            return  null;
        }
        Demo result = BeanCopierUtils.copyOne2One(demoDoResul,Demo.class);
        return result;
    }
}
