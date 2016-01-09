package com.puiui.auth.dao;

import com.puiui.auth.domain.Dept;

import java.util.List;

public interface DeptDao {
    List<Dept> findByParentId(Long pid);

    Integer findMaxSortCodeByParentId(Long pid);

    boolean findExistOfDeptName(Long pid, String deptName);

    List<Dept> findDeptOfRoot();

    void updateSortCodeOfAdd(Long pid, Integer sortCode);

    void updateSortCodeOfReduce(Long pid, Integer sortCode);
}
