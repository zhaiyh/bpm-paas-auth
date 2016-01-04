package com.puiui.auth.service.impl;

import com.puiui.auth.service.DeptService;
import com.puiui.auth.web.dto.DeptDto;
import org.springframework.stereotype.Component;
import com.avaje.ebean.EbeanServer;
import javax.annotation.Resource;
import java.util.List;

@Component
public class DeptServiceImpl implements DeptService {
	@Resource
	private EbeanServer ebeanServer;
	public EbeanServer getEbeanServer() {
		return ebeanServer;
	}
	public void setEbeanServer(EbeanServer ebeanServer) {
		this.ebeanServer = ebeanServer;
	}

	public List<DeptDto> queryByParent(Long pid) {

		return null;
	}
}
