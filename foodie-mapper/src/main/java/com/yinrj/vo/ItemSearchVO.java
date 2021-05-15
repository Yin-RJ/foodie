package com.yinrj.vo;

import lombok.Data;

/**
 * @author yinrongjie
 * @version 1.0
 * @description
 * @date 2021/5/16
 */
@Data
public class ItemSearchVO {
    private String itemId;
    private String itemName;
    private Integer sellCounts;
    private String imgUrl;
    private Integer price;
}
