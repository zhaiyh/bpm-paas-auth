package com.puiui.auth.web.controller;

import com.puiui.auth.domain.Dept;
import com.puiui.auth.service.DeptService;
import com.puiui.auth.web.dto.DeptDto;
import com.puiui.auth.web.dto.TreeDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by zhaiyinghao on 2016/1/3.
 */
@Controller
@RequestMapping("/dept")
public class DeptController {
    @Resource
    private DeptService deptService;

    @ResponseBody
    @RequestMapping(value = "/tree/{pid}", method = RequestMethod.GET)
    public List<TreeDto> listByParent(@PathVariable Long pid) {
        List<TreeDto> treeDtos = deptService.queryTreeByParentId(pid);
        return treeDtos;
    }

    public DeptService getDeptService() {
        return deptService;
    }

    public void setDeptService(DeptService deptService) {
        this.deptService = deptService;
    }
}
