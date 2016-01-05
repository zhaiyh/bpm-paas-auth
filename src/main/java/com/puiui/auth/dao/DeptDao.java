package com.puiui.auth.dao;

import com.puiui.auth.domain.Dept;

import java.util.List;

public interface DeptDao {
    List<Dept> findPartByParentId(Long pid);
}
