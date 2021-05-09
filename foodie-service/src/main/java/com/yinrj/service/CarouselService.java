package com.yinrj.service;

import com.yinrj.pojo.Carousel;

import java.util.List;

/**
 * @author yinrongjie
 * @version 1.0
 * @description
 * @date 2021/5/9
 */
public interface CarouselService {
    /**
     * 查询所有有效的轮播图
     * @return
     */
    List<Carousel> queryAllCarousel();
}
