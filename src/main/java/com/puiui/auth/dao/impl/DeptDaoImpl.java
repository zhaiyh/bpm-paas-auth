package com.puiui.auth.dao.impl;

import com.avaje.ebean.Ebean;
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

    public List<Dept> findByParentId(Long pid) {
        return ebeanServer
                .find(Dept.class)
                .where("parent_id = :pid")
                .setParameter("pid", pid)
                .orderBy("sortCode")
                .findList();
    }

    public Integer findMaxSortCodeByParentId(Long pid) {
        String sql = "select max(sort_code) code"
                    +  " from auth_dept"
                    +  " where parent_id = :pid";
        return Ebean
                .createSqlQuery(sql)
                .setParameter("pid", pid)
                .findUnique()
                .getInteger("code");
    }

    public boolean findExistOfDeptName(Long pid, String deptName) {
        return Ebean
                .find(Dept.class)
                .where()
                .eq("deptName", deptName)
                .eq("parent_id", pid)
                .findRowCount() > 0;
    }

    public List<Dept> findDeptOfRoot() {
        return Ebean
                .find(Dept.class)
                .where("parent_id is null")
                .orderBy()
                .asc("sortCode")
                .findList();
    }

    public void updateSortCodeOfAdd(Long pid, Integer sortCode) {
        String sql = " update" +
                        " auth_dept" +
                    " set sort_code = sort_code + 1" +
                    " where parent_id = :pid " +
                    " and sort_code >= :sortCode";
        ebeanServer
                .createSqlUpdate(sql)
                .setParameter("pid", pid)
                .setParameter("sortCode", sortCode)
                .execute();
    }

    public void updateSortCodeOfReduce(Long pid, Integer sortCode) {
        String sql = " update" +
                        " auth_dept" +
                    " set sort_code = sort_code - 1" +
                    " where parent_id = :pid " +
                    " and sort_code > :sortCode";
        ebeanServer
                .createSqlUpdate(sql)
                .setParameter("pid", pid)
                .setParameter("sortCode", sortCode)
                .execute();
    }

    public EbeanServer getEbeanServer() {
        return ebeanServer;
    }

    public void setEbeanServer(EbeanServer ebeanServer) {
        this.ebeanServer = ebeanServer;
    }
}
