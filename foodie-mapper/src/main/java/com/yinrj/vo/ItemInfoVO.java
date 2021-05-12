package com.yinrj.vo;


import com.yinrj.pojo.Items;
import com.yinrj.pojo.ItemsImg;
import com.yinrj.pojo.ItemsParam;
import com.yinrj.pojo.ItemsSpec;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author yinrongjie
 * @version 1.0
 * @description 商品详情
 * @date 2021/5/12
 */
@Data
@AllArgsConstructor
public class ItemInfoVO {
    private Items item;
    private List<ItemsImg> itemImgList;
    private List<ItemsSpec> itemSpecList;
    private ItemsParam itemParams;
}
