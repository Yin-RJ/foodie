package com.yinrj.service.impl;

import com.yinrj.dao.CategoryDao;
import com.yinrj.pojo.Category;
import com.yinrj.service.CategoryService;
import com.yinrj.vo.CategoryVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author yinrongjie
 * @version 1.0
 * @description
 * @date 2021/5/9
 */
@Service("CategoryServiceImpl")
public class CategoryServiceImpl implements CategoryService {
    private static final Integer ROOT_TYPE = 1;
    private final CategoryDao categoryDao;

    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    /**
     * 得到所有的一级分类
     *
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Category> queryAllRootCategory() {
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("type", ROOT_TYPE);
        return categoryDao.selectByExample(example);
    }

    /**
     * 根据一级分类的id获得二级分类和三级分类的内容
     *
     * @param rootId
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<CategoryVO> queryAllCategoryOfRoot(int rootId) {
        return categoryDao.querySubCategory(rootId);
    }
}
