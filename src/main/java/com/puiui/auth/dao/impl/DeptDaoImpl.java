package com.puiui.auth.dao.impl;

import com.avaje.ebean.EbeanServer;
import com.puiui.auth.dao.DeptDao;
import com.puiui.auth.domain.Dept;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class DeptDaoImpl implements DeptDao {
    @Resource
    private EbeanServer ebeanServer;

    public List<Dept> findPartByParentId(Long pid) {
        return ebeanServer
                .find(Dept.class)
                .select("id, deptName")
                .where()
                .eq("parent_id", pid)
                .findList();
    }

    public EbeanServer getEbeanServer() {
        return ebeanServer;
    }

    public void setEbeanServer(EbeanServer ebeanServer) {
        this.ebeanServer = ebeanServer;
    }
}
