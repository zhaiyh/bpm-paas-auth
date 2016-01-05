package com.puiui.auth.service.impl;

import com.puiui.auth.dao.DeptDao;
import com.puiui.auth.dao.UserDao;
import com.puiui.auth.domain.Dept;
import com.puiui.auth.domain.User;
import com.puiui.auth.service.DeptService;
import com.puiui.auth.web.dto.DeptDto;
import org.springframework.stereotype.Component;
import com.avaje.ebean.EbeanServer;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class DeptServiceImpl implements DeptService {
    @Resource
    private EbeanServer ebeanServer;
    @Resource
    private DeptDao deptDao;
    @Resource
    private UserDao userDao;

    public List<DeptDto> queryByParentId(Long pid) {
        List<Dept> depts = deptDao.findByParentId(pid);
        List<User> users = userDao.findByDeptId(pid);
        System.out.println(depts);
        System.out.println(users);
        return null;
    }

    public DeptDao getDeptDao() {
        return deptDao;
    }

    public void setDeptDao(DeptDao deptDao) {
        this.deptDao = deptDao;
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
