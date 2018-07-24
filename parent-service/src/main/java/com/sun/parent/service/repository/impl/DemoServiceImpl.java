package com.sun.parent.service.repository.impl;

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
    public Demo selectOne(Demo demo) {
        DemoDO demoDo = new DemoDO();
        demoDo.setId(demo.getId());
        DemoDO demoDoResul = demoDOMapper.selectOne(demoDo);
        Demo result = new Demo();
        result.setId(demoDoResul.getId());
        result.setName(demoDoResul.getName());
        return result;
    }
}
