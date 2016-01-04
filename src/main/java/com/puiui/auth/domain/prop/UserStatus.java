package com.puiui.auth.domain.prop;

import com.avaje.ebean.annotation.EnumValue;

/**
 * Created by zhaiyinghao on 2015/12/17.
 */
public enum UserStatus {
    @EnumValue("D") DELETED, // 已删除
    @EnumValue("A") ACTIVE, // 已激活
    @EnumValue("I") INACTIVE, // 未激活
    @EnumValue("L") LOCKED, // 已锁定
}
