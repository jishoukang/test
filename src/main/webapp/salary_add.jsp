<%--
  Created by IntelliJ IDEA.
  User: 康小羽的电小脑
  Date: 2021/1/3
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html lang="en" >--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <title>添加员工信息</title>--%>
<%--    <link href="css/register.css" rel="stylesheet" type="text/css">--%>
<%--    <link href="css/font-awesome.css" rel="stylesheet" type="text/css">--%>
<%--</head>--%>
<%--<body>--%>

<%--<form>--%>
<%--    <div class="navigation">--%>
<%--        <ul class="top-nav">--%>
<%--            <li class="nav-list"><a href="employee_login.html"><i class="fa fa-sign-in" style="color: white"></i></a></li>--%>
<%--        </ul>--%>
<%--    </div>--%>
<%--    <div class="register_form_back"></div>--%>
<%--    <div class="form_pos">--%>
<%--        <div class="register_text"></div>--%>
<%--        <a>添加工资信息</a>--%>
<%--        <div class="register_form">--%>
<%--            <div class="data">工&nbsp;&nbsp;&nbsp;&nbsp;号：<input type="text" name="id"></div>--%>
<%--            <div class="data">姓&nbsp;&nbsp;&nbsp;&nbsp;名：<input type="text" name="username"></div>--%>
<%--            <div class="data">部&nbsp;&nbsp;&nbsp;&nbsp;门：<input type="text" name="department"></div>--%>
<%--            <div class="data">基本工资：<input type="text" name="basic_salary"></div>--%>
<%--            <div class="data">出勤天数：<input type="text" name="attendance_day"></div>--%>
<%--            <div class="data">出勤工资：<input type="text" name="attendance_salary"></div>--%>
<%--            <div class="data">加班工资：<input type="text" name="overtime_salary"></div>--%>
<%--            <div class="data">夜班津贴：<input type="text" name="night_differential"></div>--%>
<%--            <div class="data">全&nbsp;勤&nbsp;奖：<input type="text" name="attendance_bonus"></div>--%>
<%--            <div class="data">扣&nbsp;&nbsp;&nbsp;&nbsp;款：<input type="text" name="withhold"></div>--%>
<%--            <div class="data">五险一金：<input type="text" name="insurance"></div>--%>
<%--            <div class="data">实发工资：<input type="text" name="actual_salary"></div>--%>
<%--        </div>--%>
<%--        <div class="register_button">--%>
<%--            <input type="submit" value="添加" formaction="<%=request.getContextPath()%>/SalaryAddServlet">--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>个人中心</title>
    <link href="css/person_info.css" rel="stylesheet" type="text/css">
    <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <style>
        .right form input{
            height: 30px;
            width: 260px;
            margin-left: 10px;
            border:1px solid rgba(0,0,0,0);
            outline: none ;
            font-size: 28px;
            font-family: 新宋体;
        }
    </style>
</head>
<body>
<div class="navigation">
    <ul class="top-nav"></ul>
</div>
<div class="back-img"></div>
<div class="left">
    <div class="info-title" style="margin-top: 180px">添加新用户</div>
</div>
<div class="right">
    <form style="line-height: 40px;font-family: 华文宋体;font-size: 30px;margin-top: 80px;margin-left: 50px">
        <div>工&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:<input type="text" name="id"></div>
        <div>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:<input type="text" name="username"></div>
        <div>部&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;门:<input type="text" name="department"></div>
        <div>基本工资：<input type="text" name="basic_salary"></div>
        <div>出勤天数：<input type="text" name="attendance_day"></div>
        <div>出勤工资：<input type="text" name="attendance_salary"></div>
        <div>加班工资：<input type="text" name="overtime_salary"></div>
        <div>夜班津贴：<input type="text" name="night_differential"></div>
        <div>全&nbsp;勤&nbsp;奖：<input type="text" name="attendance_bonus"></div>
        <div>扣&nbsp;&nbsp;&nbsp;&nbsp;款：<input type="text" name="withhold"></div>
        <div>五险一金：<input type="text" name="insurance"></div>
        <div>实发工资：<input type="text" name="actual_salary"></div>
<%--        <input type="submit" value="添加" formaction="<%=request.getContextPath()%>/SalaryAddServlet">--%>
        <input formaction="<%=request.getContextPath()%>/SalaryAddServlet" type="submit" style="float: left;height:80px;margin-top: 50px;margin-left:35%;background-color: #2D93CA;cursor: pointer">
    </form>
</div>
</body>
</html>
