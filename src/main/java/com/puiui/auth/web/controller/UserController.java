package com.puiui.auth.web.controller;

import com.puiui.auth.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zhaiyinghao on 2016/1/2.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @ResponseBody
    @RequestMapping("/list")
    public List<User> list() {
//        List<User> list = userService.queryAll();
        return null;
    }

}
