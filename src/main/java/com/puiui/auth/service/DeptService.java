package com.puiui.auth.service;

import com.puiui.auth.web.dto.TreeDto;

import java.util.List;

public interface DeptService {
    List<TreeDto> queryTreeByParentId(Long pid);
}
