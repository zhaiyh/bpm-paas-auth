package com.puiui.auth.service.impl;

import com.avaje.ebean.EbeanServer;
import com.puiui.auth.dao.UserDao;
import com.puiui.auth.domain.User;
import com.puiui.auth.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserServiceImpl implements UserService {
    @Resource
    private EbeanServer ebeanServer;

    @Resource
    private UserDao userDao;

    public User login(String username, String password) {
        return userDao.login(username, password);
    }

    public EbeanServer getEbeanServer() {
        return ebeanServer;
    }

    public void setEbeanServer(EbeanServer ebeanServer) {
        this.ebeanServer = ebeanServer;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
