package com.bjpowernode.crm.workbench.activity.service.impl;

import com.bjpowernode.crm.commons.util.PagenationVO;
import com.bjpowernode.crm.commons.util.SqlSessionUtil;
import com.bjpowernode.crm.workbench.activity.mapper.ActivityMapper;
import com.bjpowernode.crm.workbench.activity.model.Activity;
import com.bjpowernode.crm.workbench.activity.service.ActivityService;

/**
 * 市场活动实现类
 *
 * @auto admin
 * @data 2019/3/18 20:44
 */
public class ActivitySeriviceImpl implements ActivityService {


    private ActivityMapper activityMapper = SqlSessionUtil.getSqlSession().getMapper(ActivityMapper.class);

    /**
     * 分页查询市场活动列表
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public PagenationVO<Activity> queryActivityListByPage(int currentPage, int pageSize) {
        PagenationVO<Activity> pagenationVO = new PagenationVO<>();
        pagenationVO.setDataList(activityMapper.selectActivityByPage(currentPage, pageSize));
        pagenationVO.setTotal(activityMapper.selecAllActivityCount());
        return pagenationVO;


    }
}
