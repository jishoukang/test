<%--
  Created by IntelliJ IDEA.
  User: 康小羽的电小脑
  Date: 2020/12/30
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>工资预览</title>
    <link href="css/person_info.css" rel="stylesheet" type="text/css">
    <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="navigation">
    <ul class="top-nav">
<%--        <li class="nav-list" style="border:1px solid rgba(0,0,0,0);width: 100px;"><a>个人中心</a></li>--%>
        <li class="nav-salary" style="border:1px solid rgba(0,0,0,0);color:white;width: 80px;font-size: 20px;margin-left:-100px"><a>查看工资</a></li>
        <li class="nav-out" style="border: 1px solid rgba(0,0,0,0);width: 50px; margin-top:-30px;margin-left:1280px"><a href="employee_login.jsp"><i class="fa fa-sign-out" style="color: white;font-size: 30px;cursor: pointer"></i></a></li>
    </ul>
</div>
<div class="back-img"></div>
<div class="left">
    <div class="info-title">工资信息展示</div>
</div>
<div class="right">
    <form style="line-height: 80px;font-family: 华文宋体;font-size: 30px;margin-top: 80px;margin-left: 50px">
        <div>工&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:${salary.id}</div>
        <div>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:${salary.username}</div>
        <div>部&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;门:${salary.department}</div>
        <div>基本工资:${salary.base_salary}</div>
        <div>加班工资:${salary.overtime_salary}</div>
        <div>五险一金:${salary.insurance}</div>
        <div>实发工资:${salary.actual_salary}</div>
    </form>
</div>
</body>
</html>
