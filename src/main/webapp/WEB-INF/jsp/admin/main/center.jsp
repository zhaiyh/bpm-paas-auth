<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<div style="padding: 10px;">
    <div id="baseInfoId" class="easyui-panel" title="基本信息"
         data-options="cls:'baseInfoPanel',iconCls:'icon-door',bodyCls:'baseInfoBody'">
        <div style="text-align: center; padding: 20px;">
            <div style="padding-top: 10px;padding-bottom: 10px;">
                <span>当前在线用户数：${onlineUserNum}</span></div>
            <div style="padding-top: 10px;padding-bottom: 10px;"><span>当前线程数：${systemInfo.totalThread}</span></div>
            <div style="padding-top: 10px;padding-bottom: 10px;"><span>操作系统：${systemInfo.osName}</span></div>
        </div>
    </div>
    <div id="cpuMonitorId" class="easyui-panel" title="CPU运行监控"
         data-options="iconCls:'icon-chart_curve', cls:'cpuPanel',bodyCls:'cpuMonitorBody', onLoad:initEchart()">
        <div id="cpuProfile" style="width: 64.8%;height: 350px;"></div>
    </div>
</div>
<div id="memoryMonitorId" class="easyui-panel" title="系统监控"
     data-options="iconCls:'icon-chart_line', cls:'mainPanel', onLoad:initMemory()">
    <div id="memoryProfile" style="width: 97.8%; height: 350px;"></div>
</div>