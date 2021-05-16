package com.yinrj.dto;

import lombok.Data;

/**
 * @author yinrongjie
 * @version 1.0
 * @description
 * @date 2021/5/16
 */
@Data
public class ShopCartDto {
    private String itemId;
    private String itemImgUrl;
    private String itemName;
    private String specId;
    private String specName;
    private Integer buyCounts;
    private String priceDiscount;
    private String priceNormal;
}
