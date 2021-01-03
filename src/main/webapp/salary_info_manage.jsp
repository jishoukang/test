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
    <link href="css/salary_info_manage.css" rel="stylesheet" type="text/css">
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
<%--                    <div class="sly-sts-area">--%>
<%--                        <div class="sly-sts">--%>
<%--                            <a href="<%=request.getContextPath()%>/SalaryTotlaServlet"><i class="fa fa-pie-chart"></i>工资统计</a>--%>
<%--                        </div>--%>
<%--                    </div>--%>
                </div>
                <div class="form-content">
                    <div class="content-title"><p>工资信息管理</p></div>
                    <div class="content-list">
                        <div class="content-list-title"><p>工资信息列表</p></div>
                        <div class="content-list-frame">
                            <div class="content-search">
                                <div class="search-frame">
                                    <input type="text" name="id" placeholder="请输入员工工号">
                                </div>
                                <div class="search-button">
                                    <input type="submit"  formaction="<%=request.getContextPath()%>/SalarySearchServlet" value="搜索">
                                </div>
                            </div>
                            <div class="content-add">
<%--                                <input type="submit" value="添加">--%>
                                    <input type="submit" formaction="salary_add.jsp" value="添加">
<%--                                    <div class="content-add"><input type="submit" value="添加"></div>--%>

                            </div>

                        </div>
                        <div class="content-list-form">
                            <table border="1px" bordercolor="darkgray" cellspacing="0" width="1408px" style="line-height:30px;margin-left: 12px;font-family:宋体">
                                <tr align="center" style="background-color: antiquewhite">
                                    <td>工号</td>
                                    <td>姓名</td>
                                    <td>部门</td>
                                    <td>基本工资</td>
                                    <td>出勤天数</td>
                                    <td>出勤工资</td>
                                    <td>加班工资</td>
                                    <td>夜班津贴</td>
                                    <td>全勤奖</td>
                                    <td>扣款</td>
                                    <td>五险一金</td>
                                    <td>实发工资</td>
                                    <td width="200px">操作</td>
                                </tr>
                                <c:forEach items="${salary}" var="i">
                                    <tr>
                                        <td>${i.id}</td>
                                        <td>${i.username}</td>
                                        <td>${i.department}</td>
                                        <td>${i.base_salary}</td>
                                        <td>${i.attendance_day}</td>
                                        <td>${i.attendance_salary}</td>
                                        <td>${i.overtime_salary}</td>
                                        <td>${i.night_differential}</td>
                                        <td>${i.attendance_bonus}</td>
                                        <td>${i.withhold}</td>
                                        <td>${i.insurance}</td>
                                        <td>${i.actual_salary}</td>
                                        <td width="200px" >
<%--                                            <input type="submit" value="删除" formaction="<%=request.getContextPath()%>/SalarySearchServlet?empId=${i.id}"--%>
<%--                                            style="width:60px; height: 42px;float: left;margin-left: 27px"  >--%>
                                            <%-- 修改--%>
<%--                                            <a onclick="location.reload()" href="SalaryDeleteServlet?empId=${i.id}"><i class="fa fa-remove"></i></a>--%>
<%--                                            &lt;%&ndash; 修改&ndash;%&gt;--%>
<%--                                            <a onclick="location.reload()" href="SlySaveIdServlet?slyId=${i.id}"><i class="fa fa-remove"></i></a>--%>
<%--                                        <input type="submit" value="修改" style="width:60px; height: 42px;float: left;margin-left: 30px">--%>
                                            <a onclick="location.reload()" href="SalaryDeleteServlet?slyId=${i.id}"><i class="fa fa-remove" style="font-size:30px;color: red;margin-left: 50px"></i></a>
                                            <a onclick="location.reload()" href="SlySaveIdServlet?slyId=${i.id}"><i class="fa fa-wrench" style="font-size: 26px;color: #007DDB;margin-left: 47px"></i></a>
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
