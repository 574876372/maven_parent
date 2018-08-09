package com.sun.parent.facade.bean;

import com.sun.parent.facade.bean.abs.AbstractRequest;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.facade.bean.TestDemoRequest.java
 * @Date 11:49 2018/8/8
 * To change this template use File | Settings | File Templates.
 */
public class TestDemoRequest extends AbstractRequest {

    private static final long serialVersionUID = -8501965455790678463L;


    @NotBlank(message = "id 不能为空或NULL")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}