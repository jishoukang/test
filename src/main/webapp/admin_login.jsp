<%--
  Created by IntelliJ IDEA.
  User: 康小羽的电小脑
  Date: 2020/12/30
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" >
<head>
    <meta charset="UTF-8">
    <title>管理员界面</title>
    <link href="css/admin_login.css" rel="stylesheet" type="text/css">
</head>
<body>
<form action="AdminLoginServlet" method="post" onsubmit="return validate()">
    <div class="titletxt">
        <p>员工工资管理系统</p>
    </div>
    <div class="loginArea">
        <div class="button_type">
            <button type="button"><a href="employee_login.jsp">员工</a></button>
            <button type="button"><a href="admin_login.jsp">管理员</a></button>
        </div>
        <div class="account_pass">
            <input type="text" placeholder="账号"  maxlength="20" name="account">
            <input type="password" placeholder="密码" maxlength="15" name="password">
        </div>
        <div class="button_use">
            <input type="submit" value="登录">
        </div>
    </div>
</form>
</body>
</html>
