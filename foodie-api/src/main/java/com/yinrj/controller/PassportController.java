package com.yinrj.controller;

import com.yinrj.service.impl.PassportServiceImpl;
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
public class PassportController {
    private final PassportServiceImpl passportService;

    public PassportController(PassportServiceImpl passportService) {
        this.passportService = passportService;
    }

    @GetMapping("/isExistUsername")
    @ResponseBody
    public int isExistUsername(@RequestParam String username) {
        if (StringUtils.isBlank(username)) {
            return 500;
        }
        boolean res = passportService.isExistUsername(username);
        return res ? 500:200;
    }
}
