package com.puiui.auth.web.controller;

import com.puiui.auth.domain.SystemInfo;
import com.puiui.auth.service.SystemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private SystemService systemService;

    @RequestMapping("/login")
    public String login() {
        return "/admin/login";
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
}
