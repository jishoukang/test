<%--
  Created by IntelliJ IDEA.
  User: 康小羽的电小脑
  Date: 2021/1/1
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="css/employee_info_manage.css" rel="stylesheet" type="text/css">
    <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <style>
        .main-form .form-content .content-list .content-list-form .delete a,a:hover,a:visited{
            font-size: 25px;
            color: black;
            font-family: 微软雅黑;
        }
    </style>
</head>
<body>
        <div class="navigation">
            <div class="title"><p>员工工资管理系统</p></div>
        </div>
        <form style="width: 1920px;height: 866px;background-color: white">
            <div class="main-form">
                <div class="form-lable-list">
                    <div class="emp-info-area">
                        <div class="emp-mg">
                            <a href="<%=request.getContextPath()%>/EmployeeInfoServlet"><i class="fa fa-user-circle"></i>员工信息</a>
                        </div>
                    </div>
                    <div class="sly-info-area">
                        <div class="sly-mg">
                            <a href="<%=request.getContextPath()%>/SalaryManageServlet"><i class="fa fa-archive"></i>工资管理</a>
                        </div>
                    </div>
                    <div class="sly-gvot-area">
                        <div class="sly-gv">
                            <a href="<%=request.getContextPath()%>/SalaryGvServlet"><i class="fa fa-gg-circle"></i>工资发放</a>
                        </div>
                    </div>
<%--                    <div class="sly-sts-area">--%>
<%--                        <div class="sly-sts">--%>
<%--                            <a href="<%=request.getContextPath()%>/SalaryTotlaServlet"><i class="fa fa-pie-chart"></i>工资统计</a>--%>
<%--                        </div>--%>
<%--                    </div>--%>
                </div>
                <div class="form-content">
                    <div class="content-title"><p>员工信息管理</p></div>
                    <div class="content-list">
                        <div class="content-list-title"><p>员工信息列表</p></div>
                        <div class="content-list-frame">
                            <div class="content-search">
                                <div class="search-frame"><input type="text" name="id" placeholder="请输入员工工号"></div>
                                <div class="search-button">
                                    <input type="submit"  formaction="<%=request.getContextPath()%>/EmployeeSearchServlet" value="搜索">
                                </div>
                            </div>
                            <div class="content-add">
                                    <button formaction="employee_add.jsp">添加</button>
<%--                                <a  href="employee_add.jsp">我是添加按钮</a>--%>
                            </div>
                        </div>
<%--                        height="585px--%>
                        <div class="content-list-form">
                            <table border="1px" bordercolor="darkgray" cellspacing="0" width="1408px" style="line-height:30px; margin-left: 12px;font-family:宋体">
                                <tr align="center" style="background-color: antiquewhite">
                                    <td>工号</td>
                                    <td>姓名</td>
                                    <td>账号</td>
                                    <td>密码</td>
                                    <td>性别</td>
                                    <td>部门</td>
                                    <td>操作</td>
                                </tr>
                                <c:forEach items="${employee}" var="i">

                                    <tr>
                                        <td>${i.id}</td>
                                        <td>${i.username}</td>
                                        <td>${i.account}</td>
                                        <td>${i.password}</td>
                                        <td>${i.sex}</td>
                                        <td>${i.department}</td>
                                        <td width="200px" class="delete">
                                            <a onclick="location.reload()" href="EmployeeDeleteServlet?empId=${i.id}"><i class="fa fa-remove" style="font-size:30px;color: red;margin-left: 50px"></i></a>
                                            <a onclick="location.reload()" href="EmpSaveIdServlet?empId=${i.id}"><i class="fa fa-wrench" style="font-size: 26px;color: #007DDB;margin-left: 47px"></i></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </form>
</body>
</html>
