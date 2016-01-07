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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return deptService.queryTreeByParentId(pid);
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Map<String, Object> add(DeptDto deptDto) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            deptService.save(deptDto);
            map.put("status", "OK");
            map.put("status", "添加成功");
        } catch (Exception e) {
            map.put("status", "ERR");
            map.put("message", "添加失败");
        }
        return map;
    }

    public DeptService getDeptService() {
        return deptService;
    }

    public void setDeptService(DeptService deptService) {
        this.deptService = deptService;
    }
}
