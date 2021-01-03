<%--
  Created by IntelliJ IDEA.
  User: 康小羽的电小脑
  Date: 2020/12/30
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" >
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link href="css/register.css" rel="stylesheet" type="text/css">
    <link href="css/font-awesome.css" rel="stylesheet" type="text/css">
</head>
<body>

<form action="EmployeeRegisterServlet" method="post" onsubmit="return validate()">
    <div class="navigation">
        <ul class="top-nav">
            <li class="nav-list"><a href="employee_login.jsp"><i class="fa fa-sign-in" style="color: white"></i></a></li>
        </ul>
    </div>
    <div class="register_form_back"></div>
    <div class="form_pos">
        <div class="register_text"></div>
        <a>注册信息填写</a>
        <div class="register_form">
            <div class="data">账&nbsp;&nbsp;&nbsp;&nbsp;号：<input type="text" name="account"></div>
            <div class="data">密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="password"></div>
            <div class="data">工&nbsp;&nbsp;&nbsp;&nbsp;号：<input type="text" name="id"></div>
            <div class="data">姓&nbsp;&nbsp;&nbsp;&nbsp;名：<input type="text" name="username"></div>
            <div class="data">性&nbsp;&nbsp;&nbsp;&nbsp;别：
                <input type="radio" name="sex" value="男" checked>男
                <input type="radio" name="sex" value="女">女
            </div>
            <div class="data">部&nbsp;&nbsp;&nbsp;&nbsp;门：<input type="text" name="department"></div>
            <div class="data">手机号：<input type="text" name="telephone"></div>
        </div>
        <div class="register_button"><input type="submit" value="注册"></div>
    </div>
</form>
</body>
</html>
