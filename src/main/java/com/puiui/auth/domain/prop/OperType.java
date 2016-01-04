package com.puiui.auth.domain.prop;

import com.avaje.ebean.annotation.EnumValue;

/**
 * Created by zhaiyinghao on 2015/12/17.
 */
public enum OperType {
    @EnumValue("C") CREATE, // 创建
    @EnumValue("D") DELETE, // 删除
    @EnumValue("U") UPDATE // 修改
}
