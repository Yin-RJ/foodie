package com.yinrj.service.impl;

import com.yinrj.dao.ItemsDao;
import com.yinrj.dao.ItemsImgDao;
import com.yinrj.dao.ItemsParamDao;
import com.yinrj.dao.ItemsSpecDao;
import com.yinrj.pojo.Items;
import com.yinrj.pojo.ItemsImg;
import com.yinrj.pojo.ItemsParam;
import com.yinrj.pojo.ItemsSpec;
import com.yinrj.service.ItemService;
import com.yinrj.vo.ItemInfoVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

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

    public ItemServiceImpl(ItemsImgDao itemsImgDao, ItemsSpecDao itemsSpecDao, ItemsParamDao itemsParamDao,
                           ItemsDao itemsDao) {
        this.itemsImgDao = itemsImgDao;
        this.itemsSpecDao = itemsSpecDao;
        this.itemsParamDao = itemsParamDao;
        this.itemsDao = itemsDao;
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
//        Example itemExample = new Example(Items.class);
//        Example.Criteria itemCriteria = itemExample.createCriteria();
//        itemCriteria.andEqualTo("id", itemId);
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
}
