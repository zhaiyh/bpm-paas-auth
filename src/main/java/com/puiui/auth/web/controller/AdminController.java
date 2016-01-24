package com.puiui.auth.web.controller;

import com.puiui.auth.domain.SystemInfo;
import com.puiui.auth.domain.User;
import com.puiui.auth.domain.prop.BasicCase;
import com.puiui.auth.service.SystemService;
import com.puiui.auth.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private SystemService systemService;
    @Resource
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        String isRemeber,
                        Model model) {
        User user = userService.login(username, password);
        if (user != null && user.getIsAdmin().equals(BasicCase.YES)) {
            return "redirect:/admin/index";
        } else if (user != null) {
            model.addAttribute("tipMsg", "您不是管理员!");
            return "/admin/loginPage";
        } else {
            model.addAttribute("tipMsg", "该账号不存在!");
            return "/admin/loginPage";
        }
    }

    @RequestMapping("/goLoginPage")
    public String goLoginPage() {
        return "/admin/loginPage";
    }

    @RequestMapping("/index")
    public String goIndex() {
        return "/admin/index";
    }

    @RequestMapping("/main/left")
    public String goMainLeft() {
        return "/admin/main/left";
    }

    @RequestMapping("/main/center")
    public String goMainCenter(Model model) {
        int onlineUserNum = systemService.getOnlineUserNum();
        SystemInfo systemInfo = systemService.getSystemInfo();
        model.addAttribute("onlineUserNum", onlineUserNum);
        model.addAttribute("systemInfo", systemInfo);
        return "/admin/main/center";
    }

    public SystemService getSystemService() {
        return systemService;
    }

    public void setSystemService(SystemService systemService) {
        this.systemService = systemService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
