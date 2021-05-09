package com.yinrj.dao;

import com.yinrj.pojo.Category;
import com.yinrj.vo.CategoryVO;
import com.yinrj.vo.NewItemsVO;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface CategoryDao extends Mapper<Category>, MySqlMapper<Category> {
    List<CategoryVO> querySubCategory(int rootCatId);

    List<NewItemsVO> queryItemByRootCat(int rootId);
}