<%--
  Created by IntelliJ IDEA.
  User: 康小羽的电小脑
  Date: 2021/1/1
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
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
                    <div class="sly-sts-area">
                        <div class="sly-sts">
                            <a href="<%=request.getContextPath()%>/SalaryTotlaServlet"><i class="fa fa-pie-chart"></i>工资统计</a>
                        </div>
                    </div>
                </div>
                <div class="form-content">
                    <div class="content-title"><p>工资统计管理</p></div>
                    <div class="content-list">
                        <div class="content-list-title"><p>工资统计信息</p></div>
                        <div class="content-list-frame">
                            <div class="content-search">
                                <div class="search-frame"><input type="text"></div>
                                <div class="search-button"></div>
                            </div>
                            <div class="content-add"></div>
                        </div>
                        <div class="content-list-form">
                            <table border="1px" bordercolor="darkgray" cellspacing="0" width="1408px" height="585px" style="margin-left: 12px;font-family:宋体">
                                <tr align="center" style="background-color: antiquewhite">
                                    <td>时间</td>
                                    <td>部门</td>
                                    <td>基本工资</td>
                                    <td>岗位工资</td>
                                    <td>奖金</td>
                                    <td>扣款</td>
                                    <>
                                </tr>
                                <c:forEach items="${info_total}" var="i">
                                    <tr>
                                        <td>${i.month}</td>
                                        <td>${i.department}</td>
                                        <td>${i.basic_salary}</td>
                                        <td>${i.post_salary}</td>
                                        <td>${i.bonus}</td>
                                        <td>${i.withhold}</td>
                                    </tr>
                                </c:forEach>
<%--                                <tr align="center">--%>
<%--                                    <td colspan="3">汇总</td>--%>
<%--                                    <td colspan="3">${info_total.total}</td>--%>
<%--                                </tr>--%>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </form>
</body>
</html>
