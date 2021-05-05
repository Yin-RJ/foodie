package com.yinrj.service.impl;

import com.yinrj.dao.UsersDao;
import com.yinrj.dto.UserDto;
import com.yinrj.pojo.Users;
import com.yinrj.service.PassportService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

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


        return null;
    }
}
