package com.yinrj.service.impl;

import com.yinrj.dao.CarouselDao;
import com.yinrj.pojo.Carousel;
import com.yinrj.service.CarouselService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author yinrongjie
 * @version 1.0
 * @description
 * @date 2021/5/9
 */
@Service("CarouselServiceImpl")
public class CarouselServiceImpl implements CarouselService {
    private final static Logger logger = LoggerFactory.getLogger(CarouselServiceImpl.class);
    private final static int USE_FLAG = 1;

    private final CarouselDao carouselDao;

    public CarouselServiceImpl(CarouselDao carouselDao) {
        this.carouselDao = carouselDao;
    }

    /**
     * 查询所有有效的轮播图
     *
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Carousel> queryAllCarousel() {
        logger.info("=========== queryAllCarousel ===========");
        Example example = new Example(Carousel.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isShow", USE_FLAG);
        example.orderBy("sort").desc();
        return carouselDao.selectByExample(example);
    }
}
