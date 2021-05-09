package com.yinrj.vo;

import lombok.Data;

import java.util.List;

/**
 * @author yinrongjie
 * @version 1.0
 * @description 二级分类
 * @date 2021/5/9
 */
@Data
public class CategoryVO {
    private Integer id;
    private String name;
    private String type;
    private String fatherId;
    /**
     * 三级分类
     */
    private List<SubCategoryVO> subCatList;
}
