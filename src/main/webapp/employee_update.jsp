<%--
  Created by IntelliJ IDEA.
  User: 康小羽的电小脑
  Date: 2021/1/3
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>修改员工信息</title>
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
    <div class="info-title" style="margin-top: 130px">员工信息修改</div>
</div>
<div class="right">
    <form style="line-height: 80px;font-family: 华文宋体;font-size: 30px;margin-top: 80px;margin-left: 50px">
        <div>姓&nbsp;&nbsp;&nbsp;名:<input type="text" name="username"></div>
        <div>账&nbsp;&nbsp;&nbsp;号:<input type="text" name="account"></div>
        <div>密&nbsp;&nbsp;&nbsp;码:<input type="password" name="password"></div>
        <div>性&nbsp;&nbsp;&nbsp;别:
            <input type="radio" name="sex" value="男" checked>男
            <input type="radio" name="sex" value="女">女
        </div>
        <div>部&nbsp;&nbsp;&nbsp;门:<input type="text" name="department"></div>
        <div>电&nbsp;&nbsp;&nbsp;&nbsp;话：<input type="text" name="telephone"></div>
        <input formaction="<%=request.getContextPath()%>/EmployeeUpdateServlet" type="submit" style="float: left;height:80px;margin-top: 50px;margin-left:35%;background-color: #2D93CA;cursor: pointer" >
    </form>
</div>
</body>
</html>
