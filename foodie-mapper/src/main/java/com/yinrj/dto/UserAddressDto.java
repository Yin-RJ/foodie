package com.yinrj.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author yinrongjie
 * @version 1.0
 * @description
 * @date 2021/5/17
 */
@Data
public class UserAddressDto {
    @NotBlank(groups = AddressUpdate.class, message = "地址为空")
    private String addressId;
    @NotBlank(message = "用户id为空")
    private String userId;
    @NotBlank(message = "用户姓名为空")
    private String receiver;
    @Pattern(message = "手机号非法", regexp = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$")
    private String mobile;
    @NotBlank(message = "参数为空")
    private String province;
    @NotBlank(message = "参数为空")
    private String city;
    @NotBlank(message = "参数为空")
    private String district;
    @NotBlank(message = "参数为空")
    private String detail;

    public interface AddressUpdate{};
}
