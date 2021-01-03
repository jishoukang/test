<%--
  Created by IntelliJ IDEA.
  User: 康小羽的电小脑
  Date: 2020/12/31
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>修改密码</title>
    <link href="css/font-awesome.css" rel="stylesheet" type="text/css">
    <link href="css/password_change.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="navigation">
    <ul class="top-nav">
        <li class="nav-list"><a href="person_info.jsp">个人中心</a></li>
        <li class="nav-list"><a href="salary_view.jsp">工资明细及反馈</a></li>
        <li class="nav-list"><a href="employee_login.jsp">退出</a></li>
    </ul>
</div>
        <form action="PwdChangeServlet" method="post" onsubmit="return validate()">

            <div class="main-area">
                <div class="title-area">
                    <div class="title-son-area">
                        <p>密码修改</p>
                    </div>
                </div>
                <div class="psd-change-area">
                    <div class="psw-son-area">
                        <i class="fa fa-key"></i><span>新密码:</span>
                        <input type="password" name="password">
                    </div>
                </div>
                <div class="button-area">
                    <div class="button-son-area">
                        <input type="submit" value="确认"><a href="employee_login.jsp"></a></div>
                </div>
            </div>
        </form>
</body>
</html>
