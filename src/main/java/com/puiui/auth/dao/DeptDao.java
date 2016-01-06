package com.puiui.auth.dao;

import com.puiui.auth.domain.Dept;
import com.puiui.auth.web.dto.TreeDto;

import java.util.List;

public interface DeptDao {
    List<Dept> findByParentId(Long pid);
}
