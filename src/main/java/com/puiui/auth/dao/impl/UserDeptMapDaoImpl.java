package com.puiui.auth.dao.impl;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.RawSql;
import com.avaje.ebean.RawSqlBuilder;
import com.puiui.auth.dao.UserDeptMapDao;
import com.puiui.auth.web.dto.TreeDto;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UserDeptMapDaoImpl implements UserDeptMapDao {
	@Resource
	private EbeanServer ebeanServer;

    public List<TreeDto> findTreeByDeptId(Long deptId) {
        String sql =
                  " select"
                    + " ud.dept_id"
                    + " ud.user_id"
                    + " u.nickname"
                    + " case ud.is_manager"
                          + " when 'Y' then 'UM'"
                          + " else 'U' end icon"
                + " from auth_user_dept_map ud"
                + " left join auth_user u"
                + " on ud.user_id = u.id"
                    + " and ud.dept_id = :deptId"
                    + " and ud.is_show = 'Y'"
                + " order by ud.sort_code asc";
        RawSql rawSql = RawSqlBuilder.parse(sql)
                            .columnMapping("ud.dept_id", "pId")
                            .columnMapping("ud.user_id", "id")
                            .columnMapping("u.nickname", "name")
                            .create();
        return Ebean.find(TreeDto.class)
                .setRawSql(rawSql)
                .setParameter("deptId", deptId)
                .findList();
    }

    public EbeanServer getEbeanServer() {
		return ebeanServer;
	}
	public void setEbeanServer(EbeanServer ebeanServer) {
		this.ebeanServer = ebeanServer;
	}
}
