package com.puiui.auth.dao.impl;

import com.avaje.ebean.EbeanServer;
import com.puiui.auth.dao.DeptDao;
import com.puiui.auth.domain.Dept;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class DeptDaoImpl implements DeptDao {
    @Resource
    private EbeanServer ebeanServer;

    public Dept findByParentId(Long pid) {
        return ebeanServer
                .find(Dept.class)
                .select("id, children")
                .where()
                .eq("parent", new Dept(pid))
                .order().asc("sortCode")
                .findUnique();
    }

    public EbeanServer getEbeanServer() {
        return ebeanServer;
    }

    public void setEbeanServer(EbeanServer ebeanServer) {
        this.ebeanServer = ebeanServer;
    }
}
