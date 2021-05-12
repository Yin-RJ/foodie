package com.yinrj.dao;

import com.yinrj.pojo.ItemsParam;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Mapper
public interface ItemsParamDao extends tk.mybatis.mapper.common.Mapper<ItemsParam>, MySqlMapper<ItemsParam> {
}