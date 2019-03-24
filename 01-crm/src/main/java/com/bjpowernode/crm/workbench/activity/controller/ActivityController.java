package com.bjpowernode.crm.workbench.activity.controller;

import com.bjpowernode.crm.commons.util.PagenationVO;
import com.bjpowernode.crm.workbench.activity.model.Activity;
import com.bjpowernode.crm.workbench.activity.service.ActivityService;
import com.bjpowernode.crm.workbench.activity.service.impl.ActivitySeriviceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * TODO
 *
 * @auto admin
 * @data 2019/3/18 20:39
 */
public class ActivityController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){

        ActivityService activityService = new ActivitySeriviceImpl();

        String sCurrentPage = request.getParameter("currentPage");
        String sPageSize = request.getParameter("pageSize");

        int currentPage,pageSize;

        if (null == sCurrentPage) {
            currentPage = 0; // 默认从头开始
        } else {
            currentPage = Integer.valueOf(sCurrentPage);
        }

        if (null == sPageSize) {
            pageSize = 10; //默认显示10条
        } else {
            pageSize = Integer.valueOf(sPageSize);
        }

        // 查询所有的市场活动列表,和总的条数
        PagenationVO<Activity> pagenationVO = activityService.queryActivityListByPage(currentPage, pageSize);


        System.out.println(pagenationVO.getTotal());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
