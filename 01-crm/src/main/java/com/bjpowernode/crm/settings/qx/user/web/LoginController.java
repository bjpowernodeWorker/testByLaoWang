package com.bjpowernode.crm.settings.qx.user.web;

import com.bjpowernode.crm.settings.qx.user.model.User;
import com.bjpowernode.crm.settings.qx.user.service.UserService;
import com.bjpowernode.crm.settings.qx.user.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户登录控制层
 *
 * @auto admin
 * @data 2019/3/9 20:32
 */
public class LoginController extends HttpServlet {

    /**
     * 用户控制层
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //返回map
        Map<String, Object> retMap = new HashMap<String, Object>();
        Map<String, Object> paramMap = new HashMap<String, Object>();


        // 用户登录
        paramMap.put("loginAct", request.getParameter("loginAct"));
        paramMap.put("loginPwd", request.getParameter("loginPwd"));
        String isRemPas = request.getParameter("isRemPas");

        // 后台查询
        UserService userService = new UserServiceImpl();
        User user = userService.queryUserByNameAndPassword(paramMap);

        // 判断结果
        if (null == user) {
            retMap.put("msg", "登录失败");
            retMap.put("ret", "FAIL");
        } else {
            // 登录成功
            request.getSession().setAttribute("user", user);
            retMap.put("msg", "登陆成功");
            retMap.put("ret", "SUCCESS");

            if ("true".equals(isRemPas)) {
                //将结果存到session中存储10天
                Cookie c1 = new Cookie("username", request.getParameter("username"));
                c1.setMaxAge(60 * 60 * 24 * 10);
                response.addCookie(c1);
                Cookie c2 = new Cookie("password", request.getParameter("password"));
                c2.setMaxAge(60 * 60 * 24 * 10);
                response.addCookie(c2);
            } else {
                // 直接返回结果
                Cookie c1=new Cookie("loginAct","");
                c1.setMaxAge(0);
                response.addCookie(c1);
                Cookie c2=new Cookie("loginPwd","");
                c2.setMaxAge(0);
                response.addCookie(c2);
            }
        }

        // 将结果返回
        response.setCharacterEncoding("utf-8");
        ObjectMapper mapper=new ObjectMapper();
        String json=mapper.writeValueAsString(retMap);

        System.out.println("session的ID:"+request.getRequestedSessionId());

        PrintWriter writer = response.getWriter();
        writer.write(json);
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
