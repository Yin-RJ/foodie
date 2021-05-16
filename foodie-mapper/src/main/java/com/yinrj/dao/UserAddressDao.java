package com.yinrj.dao;

import com.yinrj.pojo.UserAddress;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@org.apache.ibatis.annotations.Mapper
public interface UserAddressDao extends Mapper<UserAddress>, MySqlMapper<UserAddress> {
}