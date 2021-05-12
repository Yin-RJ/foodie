package com.yinrj.service;

import com.yinrj.vo.ItemInfoVO;

/**
 * @author yinrongjie
 * @version 1.0
 * @description
 * @date 2021/5/12
 */
public interface ItemService {
    /**
     * 通过商品id获得商品详细信息
     * @param itemId
     * @return
     */
    ItemInfoVO getItemInfoByItemId(String itemId);
}
