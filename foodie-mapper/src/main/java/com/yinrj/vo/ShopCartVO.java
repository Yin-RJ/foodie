package com.yinrj.vo;

import lombok.Data;

/**
 * @author yinrongjie
 * @version 1.0
 * @description
 * @date 2021/5/16
 */
@Data
public class ShopCartVO {
    private String itemId;
    private String itemName;
    private String itemImgUrl;
    private Integer priceDiscount;
    private Integer priceNormal;
    private String specName;
    private String specId;
}
