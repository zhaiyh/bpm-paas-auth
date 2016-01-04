package com.puiui.auth.service;

import com.puiui.auth.web.dto.DeptDto;

import java.util.List;

public interface DeptService {


    List<DeptDto> queryByParent(Long pid);
}
