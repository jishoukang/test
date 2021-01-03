<%--
  Created by IntelliJ IDEA.
  User: 康小羽的电小脑
  Date: 2021/1/1
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="css/salary_give_manage.css" rel="stylesheet" type="text/css">
    <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <!--    <style>-->

    <!--    </style>-->
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
                    <div class="content-title"><p>工资发放管理</p></div>
                    <div class="content-list">
                        <div class="content-list-title"><p>工资发放列表</p></div>
                        <div class="content-list-frame">
                            <div class="content-search">
<%--                                <div class="search-frame"><input type="text"></div>--%>
<%--                                <div class="search-button"><input type="submit" value="查找"></div>--%>
                                <div class="search-frame">
                                    <input type="text" name="id" placeholder="请输入员工工号">
                                </div>
                                <div class="search-button">
                                    <input type="submit"  formaction="<%=request.getContextPath()%>/SalaryGvSearchServlet" value="搜索">
                                </div>
                            </div>
                            <div class="content-add"></div>
                        </div>
                        <div class="content-list-form">
                            <table  border="1px" bordercolor="darkgray" cellspacing="0" width="1408px"  style="line-height:30px;margin-left: 12px;font-family:宋体">
                                <tr align="center" style="background-color: antiquewhite">
                                    <td>工号</td>
                                    <td>部门</td>
                                    <td>姓名</td>
                                    <td>实发工资</td>
                                    <td>发放日期</td>
                                    <td>五险一金占比</td>
                                    <td>银行卡号</td>
                                </tr>
                                <c:forEach items="${gv_salary}" var="i">
                                    <tr>
                                        <td>${i.id}</td>
                                        <td>${i.username}</td>
                                        <td>${i.department}</td>
                                        <td>${i.actual_salary}</td>
                                        <td>${i.gv_date}</td>
                                        <td>${i.inspro}</td>
                                        <td>${i.card_no}</td>
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
