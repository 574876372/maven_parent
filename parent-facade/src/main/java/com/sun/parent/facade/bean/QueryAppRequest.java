package com.sun.parent.facade.bean;

import com.sun.parent.facade.bean.abs.AbstractRequest;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.facade.bean.QueryAppRequest.java
 * @Date 11:28 2018/8/14
 * To change this template use File | Settings | File Templates.
 */
public class QueryAppRequest extends AbstractRequest {

    private static final long serialVersionUID = 4013598553776130643L;

    private String startTime;

    private String endTime;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
