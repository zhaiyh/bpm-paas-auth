package com.puiui.auth.dao.impl;

import com.avaje.ebean.Ebean;
import com.puiui.auth.dao.UserDao;
import com.puiui.auth.domain.User;
import org.springframework.stereotype.Component;
import com.avaje.ebean.EbeanServer;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {
    @Resource
    private EbeanServer ebeanServer;


    public EbeanServer getEbeanServer() {
        return ebeanServer;
    }

    public void setEbeanServer(EbeanServer ebeanServer) {
        this.ebeanServer = ebeanServer;
    }

    public User login(String username, String password) {
        return ebeanServer
                .find(User.class)
                .where()
                .eq("username", username)
                .eq("password", password)
                .findUnique();
    }
}
