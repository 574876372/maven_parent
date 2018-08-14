package com.sun.parent.common.enums;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.common.enums.PictureTypeEnum.java
 * @Date 12:43 2018/8/14
 * To change this template use File | Settings | File Templates.
 */
public enum PictureTypeEnum {

    PIC_TYPE_1("1","app例图")
    ;

    private String type;

    private String desc;


    PictureTypeEnum(String type,String desc){
        this.type = type;
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
