package com.sun.parent.common.enums;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.common.enums.LockStatusEnums.java
 * @Date 9:49 2018/8/21
 * To change this template use File | Settings | File Templates.
 */
public enum LockStatusEnums {

    UNLOCKED(0,"未加锁"),
    LOCKED(1,"加锁"),
    ;
    private Integer status;

    private String desc;

    LockStatusEnums(Integer status,String desc){
        this.status = status;
        this.desc =desc;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
