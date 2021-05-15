package com.yinrj.dao;

import com.yinrj.pojo.Items;
import com.yinrj.vo.ItemSearchVO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;
import java.util.Map;

@org.apache.ibatis.annotations.Mapper
public interface ItemsDao extends Mapper<Items>, MySqlMapper<Items> {
    List<ItemSearchVO> searchItemsByName(@Param("paramMap") Map<String, Object> map);
    List<ItemSearchVO> searchItemsByThirdCat(@Param("paramMap") Map<String, Object> map);
}