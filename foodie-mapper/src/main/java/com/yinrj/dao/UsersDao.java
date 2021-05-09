package com.yinrj.dao;

import com.yinrj.pojo.Users;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
public interface UsersDao extends Mapper<Users> {
    Integer existUsername(String username);
}