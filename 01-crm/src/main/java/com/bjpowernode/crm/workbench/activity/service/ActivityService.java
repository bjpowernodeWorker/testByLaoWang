package com.bjpowernode.crm.workbench.activity.service;

import com.bjpowernode.crm.commons.util.PagenationVO;
import com.bjpowernode.crm.workbench.activity.model.Activity;

/**
 * 市场活动业务层
 *
 * @auto admin
 * @data 2019/3/18 20:43
 */
public interface ActivityService {

    /**
     * 分页查询活动列表
     * @param currentPage
     * @param pageSize
     * @return
     */
    PagenationVO<Activity> queryActivityListByPage(int currentPage, int pageSize);
}
