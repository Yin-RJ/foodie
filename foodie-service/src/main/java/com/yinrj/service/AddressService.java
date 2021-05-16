package com.yinrj.service;

import com.yinrj.dto.UserAddressDto;
import com.yinrj.pojo.UserAddress;

import java.util.List;

/**
 * @author yinrongjie
 * @version 1.0
 * @description
 * @date 2021/5/17
 */
public interface AddressService {
    /**
     * 新增用户地址
     * @param userAddressDto
     */
    void addAddress(UserAddressDto userAddressDto);

    /**
     * 更新用户地址
     * @param userAddressDto
     */
    void updateAddress(UserAddressDto userAddressDto);

    /**
     * 通过userId查询该用户的所有地址信息
     * @param userId
     * @return
     */
    List<UserAddress> searchAllByUserId(String userId);

    /**
     * 删除地址信息
     * @param userId
     * @param addressId
     */
    void deleteAddress(String userId, String addressId);

    /**
     * 更新默认地址
     * @param userId
     * @param addressId
     */
    void updateDefaultAddress(String userId, String addressId);
}
