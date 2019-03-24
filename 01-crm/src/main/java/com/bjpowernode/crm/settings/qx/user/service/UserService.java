package com.bjpowernode.crm.settings.qx.user.service;

import com.bjpowernode.crm.settings.qx.user.model.User;

import java.util.Map;

/**
 * TODO
 *
 * @auto admin
 * @data 2019/3/10 11:09
 */
public interface UserService {


    /**
     * 通过用户名字和密码查询用户是否存在
     * @param paramMap
     * @return
     */
    User queryUserByNameAndPassword(Map<String, Object> paramMap);
}
