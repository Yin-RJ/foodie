package com.yinrj.controller;

import com.yinrj.dto.UserAddressDto;
import com.yinrj.pojo.UserAddress;
import com.yinrj.service.AddressService;
import com.yinrj.utils.IMOOCJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author yinrongjie
 * @version 1.0
 * @description
 * @date 2021/5/17
 */
@Api("地址相关api")
@RestController
@RequestMapping("/address")
public class AddressController {
    private final AddressService addressService;

    public AddressController(@Qualifier("AddressServiceImpl") AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/add")
    @ApiOperation(value = "用户新增地址", notes = "用户新增地址", httpMethod = "POST")
    public IMOOCJSONResult addAddress(@Validated @RequestBody UserAddressDto userAddressDto) {
        addressService.addAddress(userAddressDto);
        return IMOOCJSONResult.ok();
    }

    @PostMapping("/update")
    @ApiOperation(value = "用户修改地址", notes = "用户修改地址", httpMethod = "POST")
    public IMOOCJSONResult updateAddress(@Validated(UserAddressDto.AddressUpdate.class) @RequestBody UserAddressDto userAddressDto) {
        addressService.updateAddress(userAddressDto);
        return IMOOCJSONResult.ok();
    }

    @ApiOperation(value = "根据用户id查询收货地址列表", notes = "根据用户id查询收货地址列表", httpMethod = "POST")
    @PostMapping("/list")
    public IMOOCJSONResult list(@NotBlank(message = "用户id不能为空") @RequestParam String userId) {
        List<UserAddress> list = addressService.searchAllByUserId(userId);
        return IMOOCJSONResult.ok(list);
    }

    @ApiOperation(value = "用户删除地址", notes = "用户删除地址", httpMethod = "POST")
    @PostMapping("/delete")
    public IMOOCJSONResult delete(
            @NotBlank(message = "用户id为空") @RequestParam String userId,
            @NotBlank(message = "地址id为空") @RequestParam String addressId) {
        addressService.deleteAddress(userId, addressId);
        return IMOOCJSONResult.ok();
    }

    @ApiOperation(value = "用户设置默认地址", notes = "用户设置默认地址", httpMethod = "POST")
    @PostMapping("/setDefalut")
    public IMOOCJSONResult setDefalut(
            @NotBlank(message = "用户id为空") @RequestParam String userId,
            @NotBlank(message = "地址id为空") @RequestParam String addressId) {
        addressService.updateDefaultAddress(userId, addressId);
        return IMOOCJSONResult.ok();
    }
}
