package com.puiui.auth.service.impl;

import com.avaje.ebean.EbeanServer;
import com.puiui.auth.dao.DeptDao;
import com.puiui.auth.dao.UserDao;
import com.puiui.auth.dao.UserDeptMapDao;
import com.puiui.auth.domain.Dept;
import com.puiui.auth.domain.UserDeptMap;
import com.puiui.auth.domain.prop.BasicCase;
import com.puiui.auth.service.DeptService;
import com.puiui.auth.web.dto.DeptDto;
import com.puiui.auth.web.dto.TreeDto;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
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
        List<Dept> depts = deptDao.findByParentId(pid);
        List<UserDeptMap> userDeptMaps = userDeptMapDao.findByDeptId(pid);

        List<TreeDto> treeDtos = new ArrayList<TreeDto>();
        TreeDto treeDto = null;
        for (Dept dept : depts) {
            treeDto = new TreeDto();
            treeDto.setId(dept.getId());
            treeDto.setIcon("D");
            treeDto.setName(dept.getDeptName());
            treeDto.setpId(pid);
            treeDto.setTarget("");
            treeDto.setUrl("");
            treeDtos.add(treeDto);
        }

        for (UserDeptMap userDeptMap : userDeptMaps) {
            treeDto = new TreeDto();
            treeDto.setId(userDeptMap.getUser().getId());
            treeDto.setUrl("");
            treeDto.setTarget("");
            treeDto.setpId(pid);
            treeDto.setName(userDeptMap.getUser().getNickname());
            if (userDeptMap.getIsManager() == BasicCase.YES) {
                treeDto.setIcon("");
            } else {
                treeDto.setIcon("");
            }
            treeDtos.add(treeDto);
        }
        return treeDtos;
    }

    public void save(DeptDto deptDto) {
        Dept parent = ebeanServer.find(Dept.class, deptDto.getPid());
        Dept dept = new Dept(deptDto.getDeptName(), deptDto.getDeptDesc());
        Integer sortCode = deptDao.findMaxSortCodeByParentId(deptDto.getPid());
        dept.setSortCode(sortCode + 1);
        dept.setDeptLevel((short)(parent.getDeptLevel() + 1));
        dept.setParent(parent);
        dept.save();
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
