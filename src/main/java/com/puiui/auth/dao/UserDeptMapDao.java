package com.puiui.auth.dao;

import com.puiui.auth.domain.UserDeptMap;

import java.util.List;

public interface UserDeptMapDao {

    List<UserDeptMap> findPartByDeptId(Long id);

}
