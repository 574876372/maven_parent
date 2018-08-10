package com.sun.parent.facade.bean;

import com.sun.parent.facade.bean.abs.AbstractRequest;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.facade.bean.SynchronizeAppRequest.java
 * @Date 14:58 2018/8/10
 * To change this template use File | Settings | File Templates.
 */
public class SynchronizeAppRequest extends AbstractRequest {

    private static final long serialVersionUID = 3571692955204591722L;

    private String appUrl;

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
