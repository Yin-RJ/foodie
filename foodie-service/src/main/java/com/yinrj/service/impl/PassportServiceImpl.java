package com.yinrj.service.impl;

import com.yinrj.dao.UsersDao;
import com.yinrj.service.PassportService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yinrongjie
 * @version 1.0
 * @description
 * @date 2021/4/21
 */
@Service
public class PassportServiceImpl implements PassportService {

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
}
