package com.puiui.auth.service;

import com.puiui.auth.domain.User;

public interface UserService {

    void save(Long deptId, User user);

    boolean queryExistOfUsername(String username);
	
}
