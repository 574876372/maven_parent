package com.sun.parent.facade.bean.abs;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.facade.bean.AbstractRequest.java
 * @Date 11:52 2018/8/8
 * To change this template use File | Settings | File Templates.
 */
public class AbstractRequest implements Serializable{

    private String reqSerial;

    /** 系统编号 */
    private String sysId;

    /** 系统描述 **/
    private String sysDesc;

    public String getReqSerial() {
        return reqSerial;
    }

    public void setReqSerial(String reqSerial) {
        this.reqSerial = reqSerial;
    }

    public String getSysId() {
        return sysId;
    }

    public void setSysId(String sysId) {
        this.sysId = sysId;
    }

    public String getSysDesc() {
        return sysDesc;
    }

    public void setSysDesc(String sysDesc) {
        this.sysDesc = sysDesc;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
