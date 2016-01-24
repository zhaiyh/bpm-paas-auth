package com.puiui.auth.service;

import com.puiui.auth.domain.User;

public interface UserService {

    User login(String username, String password);

}
