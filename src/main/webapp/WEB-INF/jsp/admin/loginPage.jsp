<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
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
</head>
<body>
<div style="text-align: center; margin-top: 130px;">
    <form class="easyui-form" action="/admin/login" method="post" id="loginForm">
        <h2>后台登录</h2>
        <div style="padding: 10px;">
            <input class="easyui-textbox" name="username"
                   data-options="iconCls:'icon-man',width:300,height:40,prompt:'请输入用户名',type:'text',iconWidth:38,required:true,missingMessage:'用户名不能为空！'"
                   id="username" style="padding-left: 11px;">
        </div>
        <div style="padding: 10px">
            <input class="easyui-textbox" name="password"
                   data-options="iconCls:'icon-lock',width:300,height:40,type:'password',prompt:'请输入密码',iconWidth:38,required:true,missingMessage:'密码不能为空！'"
                   id="password" style="padding-left: 11px;">
        </div>
        <div style="margin: 10px;">
            <label for="remeber" style="font-size: 12px;">记住密码</label>
            <input type="checkbox" name="isRemeber" value="YES" id="remeber"
                   style="margin-right: 147px;vertical-align:middle; ">
            <input id="loginBtn" class="easyui-linkbutton"
                   data-options="width:80, height:40" type="submit"
                   value="登录">
        </div>
    </form>
    <div>${tipMsg }</div>
</div>
</body>
<script src="vendor/easyui/jquery.min.js"></script>
<script src="vendor/easyui/jquery.easyui.min.js"></script>
<script>
    $("#loginBtn").bind('click', function() {
        $("#loginForm").submit();
    });
</script>
</html>
