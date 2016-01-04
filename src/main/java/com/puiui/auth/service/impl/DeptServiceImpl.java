package com.puiui.auth.service.impl;

import com.puiui.auth.dao.DeptDao;
import com.puiui.auth.domain.Dept;
import com.puiui.auth.service.DeptService;
import com.puiui.auth.util.BeanUtil;
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

    public List<DeptDto> queryByParentId(Long pid) {
        Dept dept = deptDao.findByParentId(pid);
        Set<Dept> children = dept.getChildren();
        List<DeptDto> deptDtos = new ArrayList<DeptDto>();
        try {
            for (Dept child : children) {
                deptDtos.add(BeanUtil.transfor(child, DeptDto.class));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return deptDtos;
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
}
