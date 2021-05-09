package com.yinrj.service;

import com.yinrj.pojo.Category;
import com.yinrj.vo.CategoryVO;
import com.yinrj.vo.NewItemsVO;

import java.util.List;

/**
 * @author yinrongjie
 * @version 1.0
 * @description
 * @date 2021/5/9
 */
public interface CategoryService {
    /**
     * 得到所有的一级分类
     * @return
     */
    List<Category> queryAllRootCategory();

    /**
     * 根据一级分类的id获得二级分类和三级分类的内容
     * @param rootId
     * @return
     */
    List<CategoryVO> queryAllCategoryOfRoot(int rootId);

    /**
     * 查询一级分类下的最新的6个商品
     * @param rootId
     * @return
     */
    List<NewItemsVO> queryItemByRootCat(int rootId);
}
