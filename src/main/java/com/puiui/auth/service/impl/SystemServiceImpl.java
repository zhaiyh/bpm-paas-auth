package com.puiui.auth.service.impl;

import com.puiui.auth.domain.SystemInfo;
import com.puiui.auth.service.SystemService;
import org.springframework.stereotype.Component;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

@Component
public class SystemServiceImpl implements SystemService {
    public int getOnlineUserNum() {
        return (int) (Math.random() * 100);
    }

    public SystemInfo getSystemInfo() {
        int kb = 1024;

        // 可使用内存
        long totalMemory = Runtime.getRuntime().totalMemory() / kb;
        // 剩余内存
        long freeMemory = Runtime.getRuntime().freeMemory() / kb;
        // 最大可使用内存
        long maxMemory = Runtime.getRuntime().maxMemory() / kb;

        OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory
                .getOperatingSystemMXBean();

        // 操作系统
        String osName = System.getProperty("os.name");

        // 获得线程总数
        ThreadGroup parentThread;
        for (parentThread = Thread.currentThread().getThreadGroup(); parentThread
                .getParent() != null; parentThread = parentThread.getParent())
            ;
        int totalThread = parentThread.activeCount();
        SystemInfo systemInfo = new SystemInfo();
        systemInfo.setTotalMemory(totalMemory);
        systemInfo.setFreeMemory(freeMemory);
        systemInfo.setMaxMemory(maxMemory);
        systemInfo.setOsName(osName);
        systemInfo.setTotalThread(totalThread);
        return systemInfo;
    }

}
