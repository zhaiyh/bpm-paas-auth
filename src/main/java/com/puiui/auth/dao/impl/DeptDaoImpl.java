package com.puiui.auth.dao.impl;

import com.avaje.ebean.*;
import com.puiui.auth.dao.DeptDao;
import com.puiui.auth.web.dto.TreeDto;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class DeptDaoImpl implements DeptDao {
    @Resource
    private EbeanServer ebeanServer;

    public List<TreeDto> findTreeByParentId(Long pid) {
        String sql =
                " select"
                    + " parent_id,"
                    + " id,"
                    + " dept_name,"
                    + " 'D' icon" +
                " from auth_dept" +
                " where parent_id = :pid" +
                " order by sort_code";

        RawSql rawSql = RawSqlBuilder
                .parse(sql)
                .columnMapping("parent_id", "pId")
                .columnMapping("dept_name", "name")
                .create();

        return Ebean.find(TreeDto.class)
                    .setRawSql(rawSql)
                    .setParameter("pid", pid)
                    .findList();
    }

    public EbeanServer getEbeanServer() {
        return ebeanServer;
    }

    public void setEbeanServer(EbeanServer ebeanServer) {
        this.ebeanServer = ebeanServer;
    }
}
