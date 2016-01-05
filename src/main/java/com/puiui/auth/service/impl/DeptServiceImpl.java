package com.puiui.auth.service.impl;

import com.avaje.ebean.EbeanServer;
import com.puiui.auth.dao.DeptDao;
import com.puiui.auth.dao.UserDao;
import com.puiui.auth.dao.UserDeptMapDao;
import com.puiui.auth.domain.Dept;
import com.puiui.auth.domain.UserDeptMap;
import com.puiui.auth.service.DeptService;
import com.puiui.auth.web.dto.DeptDto;
import com.puiui.auth.web.dto.TreeDto;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Component
public class DeptServiceImpl implements DeptService {
    @Resource
    private EbeanServer ebeanServer;
    @Resource
    private DeptDao deptDao;
    @Resource
    private UserDao userDao;
    @Resource
    private UserDeptMapDao userDeptMapDao;

    public List<TreeDto> queryTreeByParentId(Long pid) {
        List<TreeDto> deptTree = deptDao.findTreeByParentId(pid);
        List<TreeDto> userTree = userDeptMapDao.findTreeByDeptId(pid);
        deptTree.addAll(userTree);
        return deptTree;
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

    public UserDeptMapDao getUserDeptMapDao() {
        return userDeptMapDao;
    }

    public void setUserDeptMapDao(UserDeptMapDao userDeptMapDao) {
        this.userDeptMapDao = userDeptMapDao;
    }
}
