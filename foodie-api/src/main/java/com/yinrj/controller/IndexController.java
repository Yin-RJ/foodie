package com.yinrj.controller;

import com.yinrj.service.CarouselService;
import com.yinrj.service.CategoryService;
import com.yinrj.utils.IMOOCJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

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

    private final CategoryService categoryService;

    public IndexController(@Qualifier("CarouselServiceImpl") CarouselService carouselService, @Qualifier(
            "CategoryServiceImpl") CategoryService categoryService) {
        this.carouselService = carouselService;
        this.categoryService = categoryService;
    }


    @GetMapping("/carousel")
    @ApiOperation(value = "获取首页轮播图")
    public IMOOCJSONResult queryAllCarousel() {
        logger.info("========= 获取首页轮播图 ============");
        return IMOOCJSONResult.ok(carouselService.queryAllCarousel());
    }

    @GetMapping("/cats")
    @ApiOperation(value = "获取商品分类(一级分类)")
    public IMOOCJSONResult queryAllRootCategory() {
        logger.info("========= 获取商品分类(一级分类) ============");
        return IMOOCJSONResult.ok(categoryService.queryAllRootCategory());
    }

    @GetMapping("/subCat/{rootCatId}")
    @ApiOperation(value = "获取商品子分类")
    public IMOOCJSONResult querySubCategory(@ApiParam(name = "rootCatId", value = "一级分类id", required = true) @NotBlank(message = "分类不存在") @PathVariable int rootCatId) {
        logger.info("========= 获取商品子分类 ============");
        return IMOOCJSONResult.ok(categoryService.queryAllCategoryOfRoot(rootCatId));
    }
}
