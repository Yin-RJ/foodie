package com.yinrj.controller;

import com.yinrj.service.ItemService;
import com.yinrj.utils.IMOOCJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

/**
 * @author yinrongjie
 * @version 1.0
 * @description
 * @date 2021/5/12
 */
@RestController
@RequestMapping("/items")
@Api("商品接口")
public class ItemsController {
    private static final Integer DEFAULT_PAGE = 1;
    private static final Integer DEFAULT_PAGE_SIZE = 10;
    private final ItemService itemService;

    public ItemsController(@Qualifier("ItemServiceImpl") ItemService itemService) {
        this.itemService = itemService;
    }

    @ApiOperation(value = "查询商品详情", notes = "查询商品详情", httpMethod = "GET")
    @GetMapping("/info/{itemId}")
    public IMOOCJSONResult info(@NotBlank(message = "商品id为空") @ApiParam(name = "itemId", value = "商品id", required = true)
                                    @PathVariable String itemId) {
        return IMOOCJSONResult.ok(itemService.getItemInfoByItemId(itemId));
    }

    @ApiOperation(value = "查询商品评价数量", notes = "查询商品评价数量", httpMethod = "GET")
    @GetMapping("/commentLevel")
    public IMOOCJSONResult getCommentsLevel(@NotBlank(message = "商品id为空") @ApiParam(name = "itemId", value = "商品id", required = true)
                                @RequestParam String itemId) {
        return IMOOCJSONResult.ok(itemService.getCommentsLevelCounts(itemId));
    }

    @ApiOperation(value = "查询商品评价", notes = "查询商品评价", httpMethod = "GET")
    @GetMapping("/comments")
    public IMOOCJSONResult getComments(@NotBlank(message = "商品id为空") @ApiParam(name = "itemId", value = "商品id", required = true)
                                            @RequestParam String itemId, @ApiParam(name = "level", value = "评价等级", required = false)
                                            @RequestParam Integer level, @ApiParam(name = "page", value = "页数", required = false)
                                            @RequestParam Integer page, @ApiParam(name = "pageSize", value = "当前页显示数量", required = false)
                                            @RequestParam Integer pageSize) {

        if (page == null) {
            page = DEFAULT_PAGE;
        }
        if (pageSize == null) {
            pageSize = DEFAULT_PAGE_SIZE;
        }
        return IMOOCJSONResult.ok(itemService.getComments(itemId, level, page, pageSize));
    }

    @ApiOperation(value = "根据名称搜索商品", notes = "根据名称搜索商品", httpMethod = "GET")
    @GetMapping("/search")
    public IMOOCJSONResult searchItemsByName(@NotBlank(message = "关键字为空") @ApiParam(name = "keywords", value = "关键字", required = true)
                                       @RequestParam String keywords, @ApiParam(name = "sort", value = "排序标准", required = false)
                                       @RequestParam String sort, @ApiParam(name = "page", value = "页数", required = false)
                                       @RequestParam Integer page, @ApiParam(name = "pageSize", value = "当前页显示数量", required = false)
                                       @RequestParam Integer pageSize) {

        if (page == null) {
            page = DEFAULT_PAGE;
        }
        if (pageSize == null) {
            pageSize = DEFAULT_PAGE_SIZE;
        }
        return IMOOCJSONResult.ok(itemService.searchItemsByName(keywords, sort, page, pageSize));
    }

    @ApiOperation(value = "根据三级分类搜索商品", notes = "根据三级分类搜索商品", httpMethod = "GET")
    @GetMapping("/catItems")
    public IMOOCJSONResult searchItemsByThirdCat(@NotBlank(message = "三级分类为空") @ApiParam(name = "catId", value = "三级分类", required = true)
                                             @RequestParam Integer catId , @ApiParam(name = "sort", value = "排序标准", required = false)
                                             @RequestParam String sort, @ApiParam(name = "page", value = "页数", required = false)
                                             @RequestParam Integer page, @ApiParam(name = "pageSize", value = "当前页显示数量", required = false)
                                             @RequestParam Integer pageSize) {

        if (page == null) {
            page = DEFAULT_PAGE;
        }
        if (pageSize == null) {
            pageSize = DEFAULT_PAGE_SIZE;
        }
        return IMOOCJSONResult.ok(itemService.searchItemsByThirdCat(catId, sort, page, pageSize));
    }

    @ApiOperation(value = "根据规格属性刷新购物车的商品信息", notes = "根据规格属性刷新购物车的商品信息", httpMethod = "GET")
    @GetMapping("/refresh")
    public IMOOCJSONResult refresh(@NotBlank(message = "规格属性为空") @ApiParam(name = "itemSpecIds", value = "规格属性", required = true)
                                                 @RequestParam String itemSpecIds) {
        return IMOOCJSONResult.ok(itemService.searchItemsBySpecId(itemSpecIds));
    }
}
