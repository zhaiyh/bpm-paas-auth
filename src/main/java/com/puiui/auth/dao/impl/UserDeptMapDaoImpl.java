package com.puiui.auth.dao.impl;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;
import com.puiui.auth.dao.UserDeptMapDao;
import com.puiui.auth.domain.UserDeptMap;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UserDeptMapDaoImpl implements UserDeptMapDao {
	@Resource
	private EbeanServer ebeanServer;

	public int findMaxSortCodeByDeptId(Long deptId) {
		String sql = "select max(sort_code) code"
				+  " from auth_user_dept_map"
				+  " where dept_id = :deptId";
		return Ebean
				.createSqlQuery(sql)
				.setParameter("deptId", deptId)
				.findUnique()
				.getInteger("code");
	}

    public List<UserDeptMap> findByDeptId(Long deptId) {
		return ebeanServer
                .find(UserDeptMap.class)
                .fetch("user")
                .fetch("dept")
                .where("dept_id = :deptId")
                .setParameter("deptId", deptId)
                .orderBy("sortCode")
                .findList();
    }

    public EbeanServer getEbeanServer() {
		return ebeanServer;
	}
	public void setEbeanServer(EbeanServer ebeanServer) {
		this.ebeanServer = ebeanServer;
	}
}
