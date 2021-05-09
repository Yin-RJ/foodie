package com.yinrj.dao;

import com.yinrj.pojo.Users;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@org.apache.ibatis.annotations.Mapper
public interface UsersDao extends Mapper<Users>, MySqlMapper<Users> {
    Integer existUsername(String username);
}