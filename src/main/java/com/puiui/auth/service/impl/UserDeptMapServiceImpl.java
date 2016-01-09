package com.puiui.auth.service.impl;

import com.puiui.auth.dao.UserDeptMapDao;
import com.puiui.auth.domain.Dept;
import com.puiui.auth.domain.UserDeptMap;
import com.puiui.auth.service.UserDeptMapService;
import org.springframework.stereotype.Component;
import com.avaje.ebean.EbeanServer;

import javax.annotation.Resource;

@Component
public class UserDeptMapServiceImpl implements UserDeptMapService {
    @Resource
    private EbeanServer ebeanServer;

    @Resource
    private UserDeptMapDao userDeptMapDao;


    public EbeanServer getEbeanServer() {
        return ebeanServer;
    }

    public UserDeptMapDao getUserDeptMapDao() {
        return userDeptMapDao;
    }

    public void setUserDeptMapDao(UserDeptMapDao userDeptMapDao) {
        this.userDeptMapDao = userDeptMapDao;
    }

    public void setEbeanServer(EbeanServer ebeanServer) {
        this.ebeanServer = ebeanServer;
    }
}
