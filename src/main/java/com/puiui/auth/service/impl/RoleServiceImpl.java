package com.puiui.auth.service.impl;

import com.puiui.auth.service.RoleService;
import org.springframework.stereotype.Component;
import com.avaje.ebean.EbeanServer;
import javax.annotation.Resource;

@Component
public class RoleServiceImpl implements RoleService {
	@Resource
	private EbeanServer ebeanServer;
	public EbeanServer getEbeanServer() {
		return ebeanServer;
	}
	public void setEbeanServer(EbeanServer ebeanServer) {
		this.ebeanServer = ebeanServer;
	}
}
