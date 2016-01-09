package com.puiui.auth.service.impl;

import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.annotation.Transactional;
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
        treeDtos.addAll(deptToTree(pid, depts));
        treeDtos.addAll(userDeptMapToTree(pid, userDeptMaps));
        return treeDtos;
    }

    @Transactional
    public void save(DeptDto deptDto) {
        Dept parent = ebeanServer.find(Dept.class, deptDto.getPid());
        Dept dept = new Dept(deptDto.getDeptName(), deptDto.getDeptDesc());
        Integer sortCode = deptDao.findMaxSortCodeByParentId(deptDto.getPid());

        if (sortCode == null) {
            dept.setSortCode(1);
        } else {
            dept.setSortCode(sortCode + 1);
        }

        dept.setDeptLevel((short) (parent.getDeptLevel() + 1));
        dept.setParent(parent);
        dept.save();
    }

    @Transactional
    public void saveRoot(DeptDto deptDto) {
        Dept dept = new Dept(deptDto.getDeptName(), deptDto.getDeptDesc());
        Integer sortCode = deptDao.findMaxSortCodeByParentId(null);
        if (sortCode == null) {
            dept.setSortCode(1);
        } else {
            dept.setSortCode(sortCode + 1);
        }
        dept.setDeptLevel((short) 1);
        dept.save();
    }

    public boolean queryExistOfDeptName(Long pid, String deptName) {
        return deptDao.findExistOfDeptName(pid, deptName);
    }

    @Transactional
    public void updateInfo(DeptDto deptDto) {
        Dept dept = ebeanServer.find(Dept.class, deptDto.getId());
        dept.setDeptName(deptDto.getDeptName());
        dept.setDeptDesc(deptDto.getDeptDesc());
        dept.update();
    }

    public List<TreeDto> queryTreeOfRoot() {
        List<Dept> depts = deptDao.findDeptOfRoot();
        return deptToTree(0L, depts);
    }

    private List<TreeDto> deptToTree(Long pid, List<Dept> depts) {
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
        return treeDtos;
    }

    private List<TreeDto> userDeptMapToTree(
            Long deptId, List<UserDeptMap> userDeptMaps) {
        List<TreeDto> treeDtos = new ArrayList<TreeDto>();
        TreeDto treeDto = null;
        for (UserDeptMap userDeptMap : userDeptMaps) {
            treeDto = new TreeDto();
            treeDto.setId(userDeptMap.getUser().getId());
            treeDto.setUrl("");
            treeDto.setTarget("");
            treeDto.setpId(deptId);
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

    @Transactional
    public void delete(Long id) {
        ebeanServer.delete(Dept.class, id);
    }

    @Transactional
    public void updateLocation(Long deptId, Long backId) {
        Dept backDept = ebeanServer.find(Dept.class, backId);
        Dept parent = backDept.getParent();
        Dept dept = ebeanServer.find(Dept.class, deptId);

        Integer beforeCode = dept.getSortCode();

        Long pid = parent.getId();
        Long beforePId = dept.getParent().getId();
        // 设置父部门
        dept.setParent(parent);
        // 设置排序编号
        dept.setSortCode(backDept.getSortCode());
        // 该部门修改后，其他部门的排序编号的修改
        deptDao.updateSortCodeOfAdd(pid, dept.getSortCode());
        deptDao.updateSortCodeOfReduce(beforePId, beforeCode);

        dept.update();
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
