package com.puiui.auth.dao;

import com.puiui.auth.domain.UserDeptMap;

import java.util.List;

public interface UserDeptMapDao {

    int findMaxSortCodeByDeptId(Long deptId);

    List<UserDeptMap> findByDeptId(Long deptId);

}
