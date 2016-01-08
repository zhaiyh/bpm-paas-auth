package com.puiui.auth.web.controller;

import com.puiui.auth.domain.Dept;
import com.puiui.auth.service.DeptService;
import com.puiui.auth.web.dto.DeptDto;
import com.puiui.auth.web.dto.TreeDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public Map<String, Object> add(@ModelAttribute DeptDto deptDto) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            deptService.save(deptDto);
            map.put("status", Boolean.TRUE);
            map.put("message", "添加成功");
        } catch (Exception e) {
            map.put("status", Boolean.FALSE);
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
