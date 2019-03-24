package com.bjpowernode.crm.workbench.activity.mapper;


import com.bjpowernode.crm.workbench.activity.model.Activity;

import java.util.List;

public interface ActivityMapper {
    int deleteByPrimaryKey(String id);

    int insert(Activity record);

    int insertSelective(Activity record);

    Activity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);

    /**
     * 分页查询市场活动列表
     * @param currentPage
     * @param pageSize
     * @return
     */
    List<Activity> selectActivityByPage(int currentPage, int pageSize);

    /**
     * 查询总的条数
     * @return
     */
    Long selecAllActivityCount();
}