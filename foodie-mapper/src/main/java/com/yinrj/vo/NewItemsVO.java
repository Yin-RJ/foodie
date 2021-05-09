package com.yinrj.vo;

import lombok.Data;

import java.util.List;

/**
 * @author yinrongjie
 * @version 1.0
 * @description 用于首页显示一级分类下的商品信息
 * @date 2021/5/9
 */
@Data
public class NewItemsVO {
    private Integer rootCatId;
    private String rootCatName;
    private String slogan;
    private String catImage;
    private String bgColor;

    private List<SimpleItemVO> simpleItemList;
}
