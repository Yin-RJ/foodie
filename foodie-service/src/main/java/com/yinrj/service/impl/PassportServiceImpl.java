package com.yinrj.service.impl;

import com.yinrj.dao.UsersDao;
import com.yinrj.dto.UserDto;
import com.yinrj.enums.Sex;
import com.yinrj.pojo.Users;
import com.yinrj.service.PassportService;
import com.yinrj.utils.EncryptUtil;
import com.yinrj.utils.UuidUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

/**
 * @author yinrongjie
 * @version 1.0
 * @description
 * @date 2021/4/21
 */
@Service
public class PassportServiceImpl implements PassportService {

    private static final String DEFAULT_IMAGE = "http://115.159.208.98/images/1.jpg";

    private final UsersDao usersDao;

    public PassportServiceImpl(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    /**
     * 判断用户名是否存在
     *
     * @param username
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean isExistUsername(String username) {
        Integer res = usersDao.existUsername(username);
        return res != 0;
    }

    /**
     * 注册用户
     *
     * @param userDto
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Users registerUser(UserDto userDto) {
        Users users = new Users();
        String userId = UuidUtil.getShortUuid();
        users.setId(userId);

        users.setPassword(EncryptUtil.encrypt(userDto.getPassword()));
        users.setUsername(userDto.getUsername());
        users.setNickname(userDto.getUsername());
        users.setFace(DEFAULT_IMAGE);
        users.setSex(Sex.SECRET.type);

        users.setCreatedTime(new Date());
        users.setUpdatedTime(new Date());

        usersDao.insert(users);
        return users;
    }

    /**
     * 用户登陆
     *
     * @param userDto
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Users login(UserDto userDto) {
        Example example = new Example(Users.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", userDto.getUsername());
        criteria.andEqualTo("password", EncryptUtil.encrypt(userDto.getPassword()));
        return usersDao.selectOneByExample(example);
    }
}
