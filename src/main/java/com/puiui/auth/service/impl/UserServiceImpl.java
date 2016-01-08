package com.puiui.auth.service.impl;

import com.avaje.ebean.EbeanServer;
import com.puiui.auth.dao.DeptDao;
import com.puiui.auth.dao.UserDao;
import com.puiui.auth.dao.UserDeptMapDao;
import com.puiui.auth.domain.Dept;
import com.puiui.auth.domain.User;
import com.puiui.auth.domain.UserDeptMap;
import com.puiui.auth.domain.prop.BasicCase;
import com.puiui.auth.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserServiceImpl implements UserService {
    @Resource
    private EbeanServer ebeanServer;
    @Resource
    private UserDao userDao;
    @Resource
    private UserDeptMapDao userDeptMapDao;
    @Resource
    private DeptDao deptDao;

    public void save(Long deptId, User user) {
        Dept dept = ebeanServer.find(Dept.class, deptId);
        user.save();
        UserDeptMap userDeptMap = new UserDeptMap();
        userDeptMap.setDept(dept);
        userDeptMap.setIsManager(BasicCase.NO);
        userDeptMap.setUser(user);
        userDeptMap.setIsShow(BasicCase.YES);
        int sortCode = userDeptMapDao.findMaxSortCodeByDeptId(deptId);
        userDeptMap.setSortCode(sortCode + 1);
        ebeanServer.save(userDeptMap);
    }

    public boolean queryExistOfUsername(String username) {
        return userDao.findExistOfUsername(username);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDeptMapDao getUserDeptMapDao() {
        return userDeptMapDao;
    }

    public void setUserDeptMapDao(UserDeptMapDao userDeptMapDao) {
        this.userDeptMapDao = userDeptMapDao;
    }

    public EbeanServer getEbeanServer() {
        return ebeanServer;
    }

    public void setEbeanServer(EbeanServer ebeanServer) {
        this.ebeanServer = ebeanServer;
    }

}
