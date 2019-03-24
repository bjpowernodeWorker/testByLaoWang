package com.bjpowernode.crm.settings.qx.user.service.impl;

import com.bjpowernode.crm.commons.util.SqlSessionUtil;
import com.bjpowernode.crm.settings.qx.user.mapper.UserMapper;
import com.bjpowernode.crm.settings.qx.user.model.User;
import com.bjpowernode.crm.settings.qx.user.service.UserService;

import java.util.Map;

/**
 * TODO
 *
 * @auto admin
 * @data 2019/3/10 11:09
 */
public class UserServiceImpl implements UserService {


    private UserMapper userMapper = SqlSessionUtil.getSqlSession().getMapper(UserMapper.class);

    /**
     * 查询用户是否存在
     *
     * @param paramMap
     * @return
     */
    @Override
    public User queryUserByNameAndPassword(Map<String, Object> paramMap) {
        return userMapper.selectUserByNameAndPassword(paramMap);
    }
}
