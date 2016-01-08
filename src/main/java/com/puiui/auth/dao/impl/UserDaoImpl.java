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

    public boolean findExistOfUsername(String username) {
        return Ebean.find(User.class)
                    .where()
                    .eq("username", username)
                    .findRowCount() > 0;
    }

    public EbeanServer getEbeanServer() {
        return ebeanServer;
    }

    public void setEbeanServer(EbeanServer ebeanServer) {
        this.ebeanServer = ebeanServer;
    }

}
