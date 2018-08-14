package com.sun.parent.facade.bean;

import com.sun.parent.facade.bean.abs.AbstractResponse;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.facade.bean.QueryAppResponse.java
 * @Date 11:30 2018/8/14
 * To change this template use File | Settings | File Templates.
 */
public class QueryAppResponse extends AbstractResponse {

    private List<AppInfo> appInfoList;

    public List<AppInfo> getAppInfoList() {
        return appInfoList;
    }

    public void setAppInfoList(List<AppInfo> appInfoList) {
        this.appInfoList = appInfoList;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
