package com.yinrj.controller;

import cn.hutool.json.JSONUtil;
import com.yinrj.dto.UserDto;
import com.yinrj.pojo.Users;
import com.yinrj.service.impl.PassportServiceImpl;
import com.yinrj.utils.CookieUtils;
import com.yinrj.utils.IMOOCJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yinrongjie
 * @version 1.0
 * @description
 * @date 2021/4/21
 */
@RestController
@RequestMapping("/passport")
@Api("用户登陆注册")
public class PassportController {
    private final PassportServiceImpl passportService;

    public PassportController(PassportServiceImpl passportService) {
        this.passportService = passportService;
    }

    @GetMapping("/usernameIsExist")
    @ApiOperation("用户名是否存在")
    public IMOOCJSONResult isExistUsername(@RequestParam String username) {
        if (StringUtils.isBlank(username)) {
            return IMOOCJSONResult.errorException("用户名不能为空");
        }
        boolean res = passportService.isExistUsername(username);
        return res ? IMOOCJSONResult.errorException("用户名已经存在"):IMOOCJSONResult.ok();
    }

    @PostMapping("/regist")
    @ApiOperation("注册用户")
    public IMOOCJSONResult registerUser(@Validated(UserDto.Regiter.class) @RequestBody UserDto userDto, HttpServletRequest request, HttpServletResponse response) {
        String password = userDto.getPassword();
        String confirmPassword = userDto.getConfirmPassword();

        if (!password.equals(confirmPassword)) {
            return IMOOCJSONResult.errorException("密码与确认密码输入不一致");
        }

        boolean isUserExist = passportService.isExistUsername(userDto.getUsername());
        if (isUserExist) {
            return IMOOCJSONResult.errorException("用户名已经存在");
        }

        Users users = passportService.registerUser(userDto);

        CookieUtils.setCookie(request, response, "user", JSONUtil.toJsonStr(setNullProperty(users)), true);
        return IMOOCJSONResult.ok();
    }

    @PostMapping("/login")
    @ApiOperation("用户登录")
    public IMOOCJSONResult login(@Validated @RequestBody UserDto userDto, HttpServletRequest request, HttpServletResponse response) {
        Users users = passportService.login(userDto);
        if (users == null) {
            return IMOOCJSONResult.errorException("用户错误");
        }

        CookieUtils.setCookie(request, response, "user", JSONUtil.toJsonStr(setNullProperty(users)), true);
        return IMOOCJSONResult.ok();
    }

    @ApiOperation(value = "用户退出登录", notes = "用户退出登录", httpMethod = "POST")
    @PostMapping("/logout")
    public IMOOCJSONResult logout(@RequestParam String userId,
                                  HttpServletRequest request,
                                  HttpServletResponse response) {

        // 清除用户的相关信息的cookie
        CookieUtils.deleteCookie(request, response, "user");

        // TODO 用户退出登录，需要清空购物车
        // TODO 分布式会话中需要清除用户数据

        return IMOOCJSONResult.ok();
    }

    private Users setNullProperty(Users userResult) {
        userResult.setPassword(null);
        userResult.setMobile(null);
        userResult.setEmail(null);
        userResult.setCreatedTime(null);
        userResult.setUpdatedTime(null);
        userResult.setBirthday(null);
        return userResult;
    }
}
