package com.puiui.auth.service;

import com.puiui.auth.domain.SystemInfo;

/**
 * Created by zhaiyinghao on 2016/1/24.
 */
public interface SystemService {
    int getOnlineUserNum();

    SystemInfo getSystemInfo();
}
