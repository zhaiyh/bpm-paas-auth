<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>Admin</title>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="vendor/easyui/themes/default/easyui.css">
    <link rel="stylesheet" href="vendor/easyui/themes/icon.css">
    <link rel="stylesheet" href="vendor/easyui-ext/IconExtension.css">
    <link rel="stylesheet" href="css/index.css">
</head>
<body id="bodyId" class="easyui-layout">
<div data-options="region:'north',border: false" style="height: 50px">
    <div style="padding:11px;">
        <a href="/admin/index" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-home'">主页</a>
        <a href="#" class="easyui-menubutton" data-options="menu:'#model',iconCls:'icon-bricks '">建模</a>
        <a href="javascript:void(0);" class="easyui-menubutton"
           data-options="menu:'#integration',iconCls:' icon-plugin'">集成</a>
        <a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-laptop'">运行</a>
        <a href="#" class="easyui-menubutton" data-options="menu:'#system',iconCls:'icon-cog'">系统</a>
        <a href="#" class="easyui-menubutton" data-options="menu:'#profile',iconCls:'icon-client'"
           style="float: right;">个人信息</a>
    </div>
    <div id="model" style="width:100px;">
        <div data-options="iconCls:'icon-2012081511767'">组织模型</div>
        <div data-options="iconCls:'icon-2012080412263'">权限模型</div>
    </div>
    <div id="integration" style="width:100px;">
        <div data-options="iconCls:'icon-clock'">定时器</div>
    </div>
    <div id="system" style="width: 100px;">
        <div data-options="iconCls:'icon-page_white_text'">系统日志</div>
        <div data-options="iconCls:'icon-edit'">参数配置</div>
    </div>
    <div id="profile" class="menu-content" style="background:#f0f0f0;padding:10px;text-align:left">
        test
    </div>
</div>
<div id="westContent" data-options="region:'west',href:'/admin/main/left'" style="width:20%;"></div>
<div id="center" data-options="region:'center',border:false">
    <div id="mainTab" class="easyui-tabs" style="height: 100%;">
        <div data-options="title:'主页',href:'admin/main/center'"></div>
    </div>
</div>
</body>
<script src="vendor/easyui/jquery.min.js"></script>
<script src="vendor/easyui/jquery.easyui.min.js"></script>
<script src="vendor/echarts3/echarts.js"></script>
<script src="js/index.js"></script>
<script type="text/javascript">
    function initEchart() {
        var myChart = echarts.init(document.getElementById('cpuProfile'));
        var base = +new Date(2015, 9, 3);
        var oneDay = 24 * 3600 * 1000;
        var date = [];

        var data = [Math.random() * 150];

        for (var i = 1; i < 100; i++) {
            var now = new Date(base += oneDay);
            date.push([now.getFullYear(), now.getMonth() + 1, now.getDate()].join('-'));
            data.push(Math.abs(Math.random() * 100));
        }

        var option = {
            legend: {
                top: 'bottom',
                data: ['意向']
            },
            toolbox: {
                show: true,
                feature: {
                    mark: {show: true},
                    dataView: {show: true, readOnly: false},
                    magicType: {show: true, type: ['line', 'bar', 'stack', 'tiled']},
                    restore: {show: true},
                    saveAsImage: {show: true}
                }
            },
            xAxis: [
                {
                    type: 'category',
                    boundaryGap: false,
                    data: date
                }
            ],
            yAxis: [
                {
                    type: 'value',
                    max: 100
                }
            ],
            dataZoom: {
                type: 'inside',
                start: 60,
                end: 80
            },
            series: [
                {
                    name: '成交',
                    type: 'line',
                    smooth: true,
                    symbol: 'none',
                    stack: 'a',
                    areaStyle: {
                        normal: {}
                    },
                    data: data
                }
            ],
            color: ['#91c7ae']
        };
        // 为echarts对象加载数据
        myChart.setOption(option);
    }

    function initMemory() {
        var myChart = echarts.init(document.getElementById('memoryProfile'));
        var option = {
            title: {
                text: '堆叠区域图'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data: ['邮件营销', '联盟广告', '视频广告', '直接访问', '搜索引擎']
            },
            toolbox: {
                feature: {
                    saveAsImage: {}
                }
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            xAxis: [
                {
                    type: 'category',
                    boundaryGap: false,
                    data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
                }
            ],
            yAxis: [
                {
                    type: 'value'
                }
            ],
            series: [
                {
                    name: '邮件营销',
                    type: 'line',
                    stack: '总量',
                    areaStyle: {normal: {}},
                    data: [120, 132, 101, 134, 90, 230, 210]
                },
                {
                    name: '联盟广告',
                    type: 'line',
                    stack: '总量',
                    areaStyle: {normal: {}},
                    data: [220, 182, 191, 234, 290, 330, 310]
                },
                {
                    name: '视频广告',
                    type: 'line',
                    stack: '总量',
                    areaStyle: {normal: {}},
                    data: [150, 232, 201, 154, 190, 330, 410]
                },
                {
                    name: '直接访问',
                    type: 'line',
                    stack: '总量',
                    areaStyle: {normal: {}},
                    data: [320, 332, 301, 334, 390, 330, 320]
                },
                {
                    name: '搜索引擎',
                    type: 'line',
                    stack: '总量',
                    label: {
                        normal: {
                            show: true,
                            position: 'top'
                        }
                    },
                    areaStyle: {normal: {}},
                    data: [820, 932, 901, 934, 1290, 1330, 1320]
                }
            ]
        };

        // 为echarts对象加载数据
        myChart.setOption(option);
    }
</script>
</html>
