package com.puiui.auth.dao.impl;

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

    public List<User> findByDeptId(Long pid) {
        return ebeanServer
                .find(User.class)
                .select("id, nickname")
                .where()
                .eq("uesrDeptMaps.dept.id", pid)
                .findList();
    }

    public EbeanServer getEbeanServer() {
        return ebeanServer;
    }

    public void setEbeanServer(EbeanServer ebeanServer) {
        this.ebeanServer = ebeanServer;
    }

}
