package com.puiui.auth.dao.impl;

import com.avaje.ebean.EbeanServer;
import com.puiui.auth.dao.UserDeptMapDao;
import com.puiui.auth.domain.UserDeptMap;
import com.puiui.auth.domain.prop.BasicCase;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UserDeptMapDaoImpl implements UserDeptMapDao {
	@Resource
	private EbeanServer ebeanServer;

    public List<UserDeptMap> findPartByDeptId(Long id) {
        return ebeanServer.find(UserDeptMap.class)
                .select("user, isManager")
                .where()
                .eq("isShow", BasicCase.YES)
                .orderBy()
                .desc("isShow")
                .findList();
    }

    public EbeanServer getEbeanServer() {
		return ebeanServer;
	}
	public void setEbeanServer(EbeanServer ebeanServer) {
		this.ebeanServer = ebeanServer;
	}
}
