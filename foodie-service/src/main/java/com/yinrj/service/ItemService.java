package com.yinrj.service;

import com.yinrj.utils.PagedGridResult;
import com.yinrj.vo.CommentsLevelCounts;
import com.yinrj.vo.ItemInfoVO;
import com.yinrj.vo.ShopCartVO;

import java.util.List;

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

    /**
     * 通过名称搜索商品
     * @param keywords
     * @param sort
     * @param page
     * @param pageSize
     * @return
     */
    PagedGridResult searchItemsByName(String keywords, String sort, Integer page, Integer pageSize);

    /**
     * 通过三级标签搜索商品
     * @param catId
     * @param sort
     * @param page
     * @param pageSize
     * @return
     */
    PagedGridResult searchItemsByThirdCat(Integer catId, String sort, Integer page, Integer pageSize);

    /**
     * 通过规格属性id获取商品信息
     * @param specIds
     * @return
     */
    List<ShopCartVO> searchItemsBySpecId(String specIds);
}
