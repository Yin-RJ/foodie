package com.yinrj.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author yinrongjie
 * @version 1.0
 * @description
 * @date 2021/4/24
 */
@Data
@ApiModel
public class UserDto {
    @ApiModelProperty("用户名")
    @NotBlank(message = "用户名不能为空")
    private String username;

    @ApiModelProperty("密码")
    @NotBlank(message = "密码不能为空")
    @Size(min = 6, message = "密码长度不能少于6位")
    private String password;

    @ApiModelProperty("确认密码")
    @NotBlank(message = "确认密码不能为空")
    private String confirmPassword;
}
