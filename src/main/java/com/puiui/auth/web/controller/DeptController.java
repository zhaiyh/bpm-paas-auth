package com.puiui.auth.web.controller;

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

        if (deptService.queryExistOfDeptName(
                deptDto.getPid(), deptDto.getDeptName())) {
            map.put("status", Boolean.FALSE);
            map.put("message", "部门名称已存在！");
            return map;
        }
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

    @ResponseBody
    @RequestMapping(value = "/update/info", method = RequestMethod.POST)
    public Map<String, Object> updateInfo(DeptDto deptDto) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            deptService.updateInfo(deptDto);
            map.put("status", Boolean.TRUE);
            map.put("message", "修改成功");
        } catch (Exception e) {
            map.put("status", Boolean.FALSE);
            map.put("message", "修改失败!");
            e.printStackTrace();
        }
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Map<String, Object> delete(@PathVariable Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            deptService.delete(id);
            map.put("status", Boolean.TRUE);
            map.put("message", "删除成功");
        } catch (Exception e) {
            map.put("status", Boolean.FALSE);
            map.put("message", "删除失败");
            e.printStackTrace();
        }
        return null;
    }

    public DeptService getDeptService() {
        return deptService;
    }

    public void setDeptService(DeptService deptService) {
        this.deptService = deptService;
    }
}
