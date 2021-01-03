<%--
  Created by IntelliJ IDEA.
  User: 康小羽的电小脑
  Date: 2020/12/30
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>个人中心</title>
    <link href="css/person_info.css" rel="stylesheet" type="text/css">
    <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="navigation">
    <ul class="top-nav">
        <li class="nav-list" style="border:1px solid rgba(0,0,0,0);width: 100px;"><a>个人中心</a></li>
<%--        <li class="nav-salary"><a>查看工资</a></li>--%>
<%--        <li class="nav-out" style="margin-top:-50px;margin-left:1280px"><a href="employee_login.jsp"><i class="fa fa-sign-out" style="color: white;font-size: 30px;cursor: pointer"></i></a></li>--%>
        <li class="nav-out" style="border: 1px solid rgba(0,0,0,0);width: 50px; margin-top:-50px;margin-left:1280px"><a href="employee_login.jsp"><i class="fa fa-sign-out" style="color: white;font-size: 30px;cursor: pointer"></i></a></li>
    </ul>
</div>
<div class="back-img"></div>
<div class="left">
    <div class="info-title">个人信息展示</div>
</div>
<div class="right">
<%--    action="SalaryViewServlet" method="post" onsubmit="return validate()"--%>
    <form style="line-height: 80px;font-family: 华文宋体;font-size: 30px;margin-top: 80px;margin-left: 50px">
        <div>昵&nbsp;&nbsp;&nbsp;称:${employee.username}</div>
        <div>账&nbsp;&nbsp;&nbsp;号:${employee.account}</div>
        <div>工&nbsp;&nbsp;&nbsp;号:${employee.id}</div>
        <div>性&nbsp;&nbsp;&nbsp;别:${employee.sex}</div>
        <div>部&nbsp;&nbsp;&nbsp;门:${employee.department}</div>
        <div>手机号:${employee.telephone}</div>
        <div>密&nbsp;&nbsp;&nbsp;码:${employee.password}</div>
        <div><button type="button" style="float: left;margin-top: 20px"><a href="password_change.jsp">修改密码</a></button></div>
        <div><button type="submit" formaction="<%=request.getContextPath()%>/SalaryViewServlet" style="float: left;margin-top: 20px;margin-left: 30px;font-family: 新宋体;font-size: 19px">查看工资</button></div>
    </form>
</div>
</body>
</html>
