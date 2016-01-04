package com.puiui.auth.dao;

import com.puiui.auth.domain.Dept;

public interface DeptDao {
    Dept findByParentId(Long pid);
}
