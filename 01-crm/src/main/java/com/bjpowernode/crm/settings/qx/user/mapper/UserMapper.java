package com.bjpowernode.crm.settings.qx.user.mapper;

import com.bjpowernode.crm.settings.qx.user.model.User;

import java.util.Map;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 通过账号密码查询账户
     * @param paramMap
     * @return
     */
    User selectUserByNameAndPassword(Map<String, Object> paramMap);
}