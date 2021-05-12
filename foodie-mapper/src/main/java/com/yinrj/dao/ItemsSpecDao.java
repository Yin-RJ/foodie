package com.yinrj.dao;

import com.yinrj.pojo.ItemsSpec;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@org.apache.ibatis.annotations.Mapper
public interface ItemsSpecDao extends MySqlMapper<ItemsSpec>, Mapper<ItemsSpec> {
}