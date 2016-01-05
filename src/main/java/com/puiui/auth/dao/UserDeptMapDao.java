package com.puiui.auth.dao;

import com.puiui.auth.web.dto.TreeDto;

import java.util.List;

public interface UserDeptMapDao {

    List<TreeDto> findTreeByDeptId(Long deptId);

}
