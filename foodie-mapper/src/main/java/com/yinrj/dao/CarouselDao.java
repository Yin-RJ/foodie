package com.yinrj.dao;

import com.yinrj.pojo.Carousel;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@org.apache.ibatis.annotations.Mapper
public interface CarouselDao extends Mapper<Carousel>, MySqlMapper<Carousel> {
}