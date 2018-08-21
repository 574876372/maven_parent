package com.sun.parent.service.bussiness;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.service.bussiness.TaskLockBusService.java
 * @Date 16:24 2018/8/17
 * To change this template use File | Settings | File Templates.
 */
public interface TaskLockBusService {

    /**
     * 根据businessType和businessId查询一条锁记录，没有则插入再加锁.存在，则直接加锁
     *
     * @param businessType
     * @param businessId
     * @return
     */
    public boolean lockTask(String businessType, String businessId);


    /**
     * 解锁
     *
     * @param businessType
     * @param businessId
     * @return
     */
    public boolean unLockTask(String businessType, String businessId);

}
