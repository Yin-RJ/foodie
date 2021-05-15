package com.yinrj.service.impl;

import com.github.pagehelper.PageHelper;
import com.yinrj.dao.*;
import com.yinrj.enums.CommentsLevelEnum;
import com.yinrj.pojo.*;
import com.yinrj.service.ItemService;
import com.yinrj.utils.DesensitizationUtil;
import com.yinrj.utils.PagedGridResult;
import com.yinrj.utils.PagedGridUtil;
import com.yinrj.vo.CommentsLevelCounts;
import com.yinrj.vo.CommentsVO;
import com.yinrj.vo.ItemInfoVO;
import com.yinrj.vo.ItemSearchVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yinrongjie
 * @version 1.0
 * @description
 * @date 2021/5/12
 */
@Service("ItemServiceImpl")
public class ItemServiceImpl implements ItemService {

    private final ItemsImgDao itemsImgDao;

    private final ItemsSpecDao itemsSpecDao;

    private final ItemsParamDao itemsParamDao;

    private final ItemsDao itemsDao;

    private final ItemsCommentsDao itemsCommentsDao;

    public ItemServiceImpl(ItemsImgDao itemsImgDao, ItemsSpecDao itemsSpecDao, ItemsParamDao itemsParamDao,
                           ItemsDao itemsDao, ItemsCommentsDao itemsCommentsDao) {
        this.itemsImgDao = itemsImgDao;
        this.itemsSpecDao = itemsSpecDao;
        this.itemsParamDao = itemsParamDao;
        this.itemsDao = itemsDao;
        this.itemsCommentsDao = itemsCommentsDao;
    }

    /**
     * 通过商品id获得商品详细信息
     *
     * @param itemId
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public ItemInfoVO getItemInfoByItemId(String itemId) {
        Items items = itemsDao.selectByPrimaryKey(itemId);

        Example paramExample = new Example(ItemsParam.class);
        Example.Criteria paramCriteria = paramExample.createCriteria();
        paramCriteria.andEqualTo("itemId", itemId);
        ItemsParam itemsParam = itemsParamDao.selectOneByExample(paramExample);

        Example imgExample = new Example(ItemsImg.class);
        Example.Criteria imgCriteria = imgExample.createCriteria();
        imgCriteria.andEqualTo("itemId", itemId);
        List<ItemsImg> itemsImgList = itemsImgDao.selectByExample(imgExample);

        Example specExample = new Example(ItemsSpec.class);
        Example.Criteria specCriteria = specExample.createCriteria();
        specCriteria.andEqualTo("itemId", itemId);
        List<ItemsSpec> itemsSpecList = itemsSpecDao.selectByExample(specExample);

        return new ItemInfoVO(items, itemsImgList, itemsSpecList, itemsParam);
    }

    /**
     * 获得商品的各评价等级的数量
     *
     * @param itemId
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public CommentsLevelCounts getCommentsLevelCounts(String itemId) {
        ItemsComments itemsComments = new ItemsComments();
        itemsComments.setItemId(itemId);
        itemsComments.setCommentLevel(CommentsLevelEnum.GOOD.type);
        Integer goodCounts = itemsCommentsDao.selectCount(itemsComments);
        itemsComments.setCommentLevel(CommentsLevelEnum.NOMAL.type);
        Integer nomalCounts = itemsCommentsDao.selectCount(itemsComments);
        itemsComments.setCommentLevel(CommentsLevelEnum.BAD.type);
        Integer badCounts = itemsCommentsDao.selectCount(itemsComments);
        return new CommentsLevelCounts(goodCounts + nomalCounts + badCounts, goodCounts, nomalCounts, badCounts);
    }

    /**
     * 分页查询评论信息
     *
     * @param itemId
     * @param level
     * @param page
     * @param pageSize
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public PagedGridResult getComments(String itemId, Integer level, Integer page, Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        map.put("itemId", itemId);
        map.put("level", level);
        PageHelper.startPage(page, pageSize);
        List<CommentsVO> commentsVOList = itemsCommentsDao.getCommentsByItemId(map);
        for (CommentsVO vo : commentsVOList) {
            vo.setNickname(DesensitizationUtil.commonDisplay(vo.getNickname()));
        }
        return PagedGridUtil.setter(commentsVOList, page);
    }

    /**
     * 通过名称搜索商品
     *
     * @param keywords
     * @param sort
     * @param page
     * @param pageSize
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public PagedGridResult searchItemsByName(String keywords, String sort, Integer page, Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        map.put("keywords", keywords);
        map.put("sort", sort);
        PageHelper.startPage(page, pageSize);
        List<ItemSearchVO> itemSearchVOList = itemsDao.searchItemsByName(map);
        return PagedGridUtil.setter(itemSearchVOList, page);
    }

    /**
     * 通过三级标签搜索商品
     *
     * @param catId
     * @param sort
     * @param page
     * @param pageSize
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public PagedGridResult searchItemsByThirdCat(Integer catId, String sort, Integer page, Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        map.put("catId", catId);
        map.put("sort", sort);
        PageHelper.startPage(page, pageSize);
        List<ItemSearchVO> itemSearchVOList = itemsDao.searchItemsByThirdCat(map);
        return PagedGridUtil.setter(itemSearchVOList, page);
    }
}
