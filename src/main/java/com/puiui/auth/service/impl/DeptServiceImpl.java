package com.puiui.auth.service.impl;

import com.avaje.ebean.EbeanServer;
import com.puiui.auth.service.DeptService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class DeptServiceImpl implements DeptService {
    @Resource
    private EbeanServer ebeanServer;
}
