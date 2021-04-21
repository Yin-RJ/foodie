package com.yinrj.dao;

import com.yinrj.pojo.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersDao {
    Integer existUsername(String username);
}