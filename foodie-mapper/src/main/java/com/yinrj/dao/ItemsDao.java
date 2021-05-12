package com.yinrj.dao;

import com.yinrj.pojo.Items;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@org.apache.ibatis.annotations.Mapper
public interface ItemsDao extends Mapper<Items>, MySqlMapper<Items> {
}