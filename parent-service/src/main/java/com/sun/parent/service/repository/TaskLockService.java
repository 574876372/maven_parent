package com.sun.parent.service.repository;

import com.sun.parent.common.exception.dao.DBException;

/**
 * @Author:ChenLei
 * @Description: com.sun.parent.service.repository.TaskLockService.java
 * @Date 16:18 2018/8/17
 * To change this template use File | Settings | File Templates.
 */
public interface TaskLockService {

    /**
     * 根据businessType和businessId判断是否存在数据
     *
     * @param businessType
     * @param businessId
     * @return
     * @throws DBException
     */
    public boolean isExistsByTypeAndId(String businessType, String businessId) throws DBException;

    /**
     * 新增一条加锁记录
     *
     * @param businessType
     * @param businessId
     * @return
     */
    public Integer addData(String businessType, String businessId) throws DBException;

    /**
     * 加锁
     *
     * @param
     * @return
     */
    public boolean updateLockTask(String businessType, String businessId) throws DBException;

    /**
     * 解锁
     *
     * @param o
     * @return
     */
    public boolean updateUnLockTask(String businessType, String businessId) throws DBException;
}
