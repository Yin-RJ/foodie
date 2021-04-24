package com.yinrj.controller;

import com.yinrj.service.impl.PassportServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/isExistUsername")
    @ResponseBody
    @ApiOperation("用户名是否存在")
    public int isExistUsername(@RequestParam String username) {
        if (StringUtils.isBlank(username)) {
            return 500;
        }
        boolean res = passportService.isExistUsername(username);
        return res ? 500:200;
    }
}
