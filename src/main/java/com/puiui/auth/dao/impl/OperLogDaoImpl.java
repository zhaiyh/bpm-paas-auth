package com.puiui.auth.dao.impl;

import com.puiui.auth.dao.OperLogDao;
import org.springframework.stereotype.Component;
import com.avaje.ebean.EbeanServer;
import javax.annotation.Resource;

@Component
public class OperLogDaoImpl implements OperLogDao {
	@Resource
	private EbeanServer ebeanServer;
	public EbeanServer getEbeanServer() {
		return ebeanServer;
	}
	public void setEbeanServer(EbeanServer ebeanServer) {
		this.ebeanServer = ebeanServer;
	}
}
