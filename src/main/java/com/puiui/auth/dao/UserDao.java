package com.puiui.auth.dao;

import com.puiui.auth.domain.User;

public interface UserDao {
    User login(String username, String password);
}
