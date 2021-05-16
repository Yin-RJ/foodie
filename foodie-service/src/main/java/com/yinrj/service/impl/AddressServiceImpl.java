package com.yinrj.service.impl;

import com.yinrj.dao.UserAddressDao;
import com.yinrj.dto.UserAddressDto;
import com.yinrj.enums.YesNoEnum;
import com.yinrj.pojo.UserAddress;
import com.yinrj.service.AddressService;
import com.yinrj.utils.UuidUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author yinrongjie
 * @version 1.0
 * @description
 * @date 2021/5/17
 */
@Service("AddressServiceImpl")
public class AddressServiceImpl implements AddressService {
    private static final Logger log = LoggerFactory.getLogger(AddressServiceImpl.class);
    private final UserAddressDao userAddressDao;

    public AddressServiceImpl(UserAddressDao userAddressDao) {
        this.userAddressDao = userAddressDao;
    }

    /**
     * 新增用户地址
     *
     * @param userAddressDto
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void addAddress(UserAddressDto userAddressDto) {
        String userId = userAddressDto.getUserId();
        UserAddress userAddress = new UserAddress();
        userAddress.setUserId(userId);
        List<UserAddress> userAddressList = userAddressDao.select(userAddress);
        int isDefault = YesNoEnum.NO.type;
        // 如果是新增的第一个地址，默认设置为默认地址
        if (userAddressList == null || userAddressList.isEmpty()) {
            isDefault = YesNoEnum.YES.type;
        }
        BeanUtils.copyProperties(userAddressDto, userAddress);
        userAddress.setId(UuidUtil.getShortUuid());
        userAddress.setIsDefault(isDefault);
        userAddress.setCreatedTime(new Date());
        userAddress.setUpdatedTime(new Date());
        userAddressDao.insert(userAddress);
    }

    /**
     * 更新用户地址
     *
     * @param userAddressDto
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateAddress(UserAddressDto userAddressDto) {
        UserAddress userAddress = new UserAddress();
        BeanUtils.copyProperties(userAddressDto, userAddress);
        // 两者的名称不一致，需要单独放入
        userAddress.setId(userAddressDto.getAddressId());
        userAddress.setUpdatedTime(new Date());
        userAddressDao.updateByPrimaryKeySelective(userAddress);
    }

    /**
     * 通过userId查询该用户的所有地址信息
     *
     * @param userId
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<UserAddress> searchAllByUserId(String userId) {
        UserAddress userAddress = new UserAddress();
        userAddress.setUserId(userId);
        return userAddressDao.select(userAddress);
    }

    /**
     * 删除地址信息
     *
     * @param userId
     * @param addressId
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void deleteAddress(String userId, String addressId) {
        UserAddress userAddress = new UserAddress();
        userAddress.setUserId(userId);
        userAddress.setId(addressId);
        UserAddress selectAddress = userAddressDao.selectOne(userAddress);
        userAddressDao.delete(userAddress);
        if (selectAddress != null && YesNoEnum.YES.type.equals(selectAddress.getIsDefault())) {
            userAddress.setId(null);
            List<UserAddress> userAddressList = userAddressDao.select(userAddress);
            if (userAddressList != null && !userAddressList.isEmpty()) {
                UserAddress firstAddress = userAddressList.get(0);
                firstAddress.setIsDefault(YesNoEnum.YES.type);
                firstAddress.setUpdatedTime(new Date());
                userAddressDao.updateByPrimaryKeySelective(firstAddress);
            }
        }
    }

    /**
     * 更新默认地址
     *
     * @param userId
     * @param addressId
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateDefaultAddress(String userId, String addressId) {
        UserAddress userAddress = new UserAddress();
        userAddress.setUserId(userId);
        userAddress.setIsDefault(YesNoEnum.YES.type);
        List<UserAddress> userAddressList = userAddressDao.select(userAddress);
        if (userAddressList != null) {
            for (UserAddress us : userAddressList) {
                us.setIsDefault(YesNoEnum.NO.type);
                us.setUpdatedTime(new Date());
                userAddressDao.updateByPrimaryKeySelective(us);
            }
        }
        UserAddress defaultAddress = new UserAddress();
        defaultAddress.setUpdatedTime(new Date());
        defaultAddress.setUserId(userId);
        defaultAddress.setId(addressId);
        defaultAddress.setIsDefault(YesNoEnum.YES.type);
        userAddressDao.updateByPrimaryKeySelective(defaultAddress);
    }
}
