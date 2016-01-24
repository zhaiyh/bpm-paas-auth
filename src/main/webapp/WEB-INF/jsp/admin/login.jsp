<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>Login</title>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="vendor/easyui/themes/default/easyui.css">
    <link rel="stylesheet" href="vendor/easyui/themes/icon.css">
    <style>
        body {
            TEXT-ALIGN: center;
        }

        .center {
            MARGIN-RIGHT: auto;
            MARGIN-LEFT: auto;
            height: 200px;
            background: #F00;
            width: 400px;
            vertical-align: middle;
        }
    </style>
</head>
<body>
<div class="easyui-panel" data-options="cls:'center'">
</div>
</body>
<script src="vendor/easyui/jquery.min.js"></script>
<script src="vendor/easyui/jquery.easyui.min.js"></script>
</html>
