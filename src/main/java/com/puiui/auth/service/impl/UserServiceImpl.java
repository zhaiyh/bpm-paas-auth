package com.puiui.auth.service.impl;

import com.puiui.auth.dao.UserDao;
import com.puiui.auth.dao.UserDeptMapDao;
import com.puiui.auth.service.UserService;
import com.puiui.auth.web.dto.UserDto;
import org.springframework.stereotype.Component;
import com.avaje.ebean.EbeanServer;
import javax.annotation.Resource;

@Component
public class UserServiceImpl implements UserService {
	@Resource
	private EbeanServer ebeanServer;

    @Resource
    private UserDao userDao;
    @Resource
    private UserDeptMapDao userDeptMapDao;

	public void save(UserDto userDto) {

	}

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDeptMapDao getUserDeptMapDao() {
        return userDeptMapDao;
    }

    public void setUserDeptMapDao(UserDeptMapDao userDeptMapDao) {
        this.userDeptMapDao = userDeptMapDao;
    }

    public EbeanServer getEbeanServer() {
		return ebeanServer;
	}
	public void setEbeanServer(EbeanServer ebeanServer) {
		this.ebeanServer = ebeanServer;
	}

}
