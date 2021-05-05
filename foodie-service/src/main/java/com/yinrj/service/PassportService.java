package com.yinrj.service;

import com.yinrj.dto.UserDto;
import com.yinrj.pojo.Users;

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

    /**
     * 注册用户
     * @param userDto
     * @return
     */
    Users registerUser(UserDto userDto);
}
