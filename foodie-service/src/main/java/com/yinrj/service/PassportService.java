package com.yinrj.service;

/**
 * @author yinrongjie
 * @version 1.0
 * @description
 * @date 2021/4/21
 */
public interface PassportService {
    /**
     * 判断用户名是否存在
     * @param username
     * @return
     */
    boolean isExistUsername(String username);
}
