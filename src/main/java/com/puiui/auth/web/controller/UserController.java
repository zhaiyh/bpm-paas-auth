package com.puiui.auth.web.controller;

import com.puiui.auth.domain.User;
import com.puiui.auth.service.UserDeptMapService;
import com.puiui.auth.service.UserService;
import com.puiui.auth.web.dto.UserDto;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhaiyinghao on 2016/1/2.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @Resource
    private UserDeptMapService userDeptMapService;

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Map<String, Object> add(Long deptId, @ModelAttribute User user) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            boolean exist = userService.queryExistOfUsername(user.getUsername());
            if(!exist) {
                userService.save(deptId, user);
                map.put("status", Boolean.TRUE);
                map.put("message", "添加成功");
            } else {
                map.put("status", Boolean.FALSE);
                map.put("message", "该用户名已存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status", Boolean.FALSE);
            map.put("message", "添加失败");
        }
        return map;
    }


    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserDeptMapService getUserDeptMapService() {
        return userDeptMapService;
    }

    public void setUserDeptMapService(UserDeptMapService userDeptMapService) {
        this.userDeptMapService = userDeptMapService;
    }
}
