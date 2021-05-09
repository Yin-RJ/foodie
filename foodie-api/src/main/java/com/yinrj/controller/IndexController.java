package com.yinrj.controller;

import com.yinrj.service.CarouselService;
import com.yinrj.utils.IMOOCJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yinrongjie
 * @version 1.0
 * @description
 * @date 2021/5/9
 */
@RestController
@Api("首页接口")
@RequestMapping("/index")
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    private final CarouselService carouselService;

    public IndexController(@Qualifier("CarouselServiceImpl") CarouselService carouselService) {
        this.carouselService = carouselService;
    }


    @GetMapping("/carousel")
    @ApiOperation(value = "获取首页轮播图")
    public IMOOCJSONResult queryAllCarousel() {
        logger.info("========= 获取首页轮播图 ============");
        return IMOOCJSONResult.ok(carouselService.queryAllCarousel());
    }
}
