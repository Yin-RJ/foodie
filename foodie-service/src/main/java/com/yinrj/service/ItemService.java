package com.yinrj.service;

import com.yinrj.utils.PagedGridResult;
import com.yinrj.vo.CommentsLevelCounts;
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

    /**
     * 获得商品的各评价等级的数量
     * @param itemId
     * @return
     */
    CommentsLevelCounts getCommentsLevelCounts(String itemId);

    /**
     * 分页查询评论信息
     * @param itemId
     * @param level
     * @param page
     * @param pageSize
     * @return
     */
    PagedGridResult getComments(String itemId, Integer level, Integer page, Integer pageSize);
}
