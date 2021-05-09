package com.yinrj.controller;

import cn.hutool.json.JSONUtil;
import com.yinrj.dto.UserDto;
import com.yinrj.pojo.Users;
import com.yinrj.service.impl.PassportServiceImpl;
import com.yinrj.utils.CookieUtils;
import com.yinrj.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

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
    public R isExistUsername(@RequestParam String username) {
        if (StringUtils.isBlank(username)) {
            return R.error("用户名不能为空");
        }
        boolean res = passportService.isExistUsername(username);
        return res ? R.error("用户名已经存在"):R.ok();
    }

    @PostMapping("/regist")
    @ApiOperation("注册用户")
    public R registerUser(@Valid @RequestBody UserDto userDto, HttpServletRequest request, HttpServletResponse response) {
        String password = userDto.getPassword();
        String confirmPassword = userDto.getConfirmPassword();

        if (!password.equals(confirmPassword)) {
            return R.error("密码与确认密码输入不一致");
        }

        boolean isUserExist = passportService.isExistUsername(userDto.getUsername());
        if (isUserExist) {
            return R.error("用户名已经存在");
        }

        Users users = passportService.registerUser(userDto);

        CookieUtils.setCookie(request, response, "user", JSONUtil.toJsonStr(setNullProperty(users)), true);
        return R.ok();
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
