package com.sun.parent.common.enums;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.common.enums.APPCodeEnum.java
 * @Date 10:40 2018/8/7
 * To change this template use File | Settings | File Templates.
 */
public enum APPCodeEnum {

    KPBF_FRAMEWORK("201", "公共框架"),
    KPBF_STRUCTRUE("202", "基础框架"),
    KPBF_REGISTER("203", "服务注册中心"),
    KPBF_OMF("204", "运营操作管理框架"),
    KPBF_WEBHUB("205", "WEBHUB"),
    KPBF_MQ("206", "消息"),
    KPBF_CACHE("207", "缓存"),
    KPBF_NTFCT("208", "沟通中心"),
    KPBF_OSS("209", "对象存储服务"),
    KPBF_CFGCT("210", "配置中心"),
    KPBF_SCHCT("211", "调度中心"),
    KPBF_LOCKER("212", "分布式锁服务"),
    KPBF_PAYWEB("213", "支付WEB"),
    KPBF_PAYMENT("214", "支付平台"),
    KPBF_CIP("215", "会员平台"),
    KPBF_ACR("216", "认证平台"),
    KPBF_MKT("217", "营销平台"),
    KPBF_COUNTER("218", "资金平台"),
    KPBF_CFTP("219", "理财平台"),
    KPBF_CAT("220", "CAT业务监控"),
    KPBF_ZABBIX("221", "系统监控"),
    KPBF_ITSM("222", "事件管控"),
    KPFN_LNEA("223", "贷前审核"),
    KPFN_LNEA_MXDATA("235", "魔蝎数据"),
    KPFN_LNDMR("236", "逾期催收"),
    KPFN_LNMTS("237", "贷款维护"),
    KPFN_LNOMS("238", "信贷作业"),
    KPFN_LNCOC("239", "委外催收公司操作平台"),
    KPRP_RCDBS("246", "风控数据基础服务"),
    KPDP_REPORTENGINE("247", "报表生成引擎"),
    NOT_SPECIFIED("999", "NotSpecified");

    public String sysId;

    public String sysDesc;

    private APPCodeEnum(String sysId, String sysDesc) {
        this.sysId = sysId;
        this.sysDesc = sysDesc;
    }
}
