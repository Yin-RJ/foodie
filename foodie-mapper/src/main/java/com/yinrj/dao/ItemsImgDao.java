package com.yinrj.dao;

import com.yinrj.pojo.ItemsImg;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@org.apache.ibatis.annotations.Mapper
public interface ItemsImgDao extends MySqlMapper<ItemsImg>, Mapper<ItemsImg> {
}