package com.yinrj.utils;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author yinrongjie
 * @version 1.0
 * @description
 * @date 2021/5/15
 */
public class PagedGridUtil {
    public static PagedGridResult setter(List<?> list, Integer page) {
        PagedGridResult result = new PagedGridResult();
        PageInfo<?> pageInfo = new PageInfo<>(list);
        result.setPage(page);
        result.setRows(list);
        result.setTotal(pageInfo.getPages());
        result.setRecords(pageInfo.getTotal());
        return result;
    }
}
