package com.puiui.auth.service;

import com.puiui.auth.web.dto.DeptDto;
import com.puiui.auth.web.dto.TreeDto;

import java.util.List;

public interface DeptService {
    List<TreeDto> queryTreeByParentId(Long pid);

    void save(DeptDto deptDto);

    boolean queryExistOfDeptName(Long pid, String deptName);

    void updateInfo(DeptDto deptDto);

    void delete(Long id);
}
