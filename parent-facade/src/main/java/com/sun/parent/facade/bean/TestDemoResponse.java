package com.sun.parent.facade.bean;

import com.sun.parent.facade.bean.abs.AbstractResponse;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.facade.bean.TestDemoResponse.java
 * @Date 13:36 2018/8/8
 * To change this template use File | Settings | File Templates.
 */
public class TestDemoResponse extends AbstractResponse {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}