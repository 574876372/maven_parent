package com.sun.parent.dao.mapper;

import com.sun.parent.dao.model.TaskLockDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Qualifier;

@BaseParentDB
@Qualifier("taskLockDOMapper")
public interface TaskLockDOMapper {

    int insert(TaskLockDO record);

    int insertSelective(TaskLockDO record);

    TaskLockDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TaskLockDO record);

    int updateByPrimaryKey(TaskLockDO record);

    /**
     *  根据businessType和businessId判断是否存在数据
     * @param businessType
     * @param businessId
     * @return
     */
    public Integer isExistsByTypeAndId(@Param("businessType") String businessType, @Param("businessId") String businessId);


    public int insertData(TaskLockDO record);


    /**
     * 加锁
     *
     * @param o
     * @return
     */
    public int updateLock(TaskLockDO o);

    /**
     * 解锁
     *
     * @param o
     * @return
     */
    public int updateUnLock(TaskLockDO o);
}