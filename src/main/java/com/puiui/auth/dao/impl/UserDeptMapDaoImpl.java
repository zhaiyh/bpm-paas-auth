package com.puiui.auth.dao.impl;

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
