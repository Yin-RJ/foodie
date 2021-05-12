package com.yinrj.controller;

import com.yinrj.service.ItemService;
import com.yinrj.utils.IMOOCJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
 * @date 2021/5/12
 */
@RestController
@RequestMapping("/items")
@Api("商品接口")
public class ItemsController {
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
}
