package com.puiui.auth.service.impl;

import com.avaje.ebean.EbeanServer;
import com.puiui.auth.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserServiceImpl implements UserService {
    @Resource
    private EbeanServer ebeanServer;

}
