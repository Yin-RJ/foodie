package com.yinrj.controller;

import com.yinrj.service.impl.PassportServiceImpl;
import com.yinrj.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.annotation.Validated;
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
    public R isExistUsername(@RequestParam String username) {
        if (StringUtils.isBlank(username)) {
            return R.error("用户名不能为空");
        }
        boolean res = passportService.isExistUsername(username);
        return res ? R.error("用户名已经存在"):R.ok();
    }
}
