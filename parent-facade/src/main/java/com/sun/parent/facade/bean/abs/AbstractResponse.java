package com.sun.parent.facade.bean.abs;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.facade.bean.abs.AbstractResponse.java
 * @Date 13:41 2018/8/8
 * To change this template use File | Settings | File Templates.
 */
public class AbstractResponse implements Serializable{

    private String reqSerial;

    /** 系统编号 */
    private String sysId;

    /** 系统描述 **/
    private String sysDesc;

    private String code;

    private String msg;


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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
