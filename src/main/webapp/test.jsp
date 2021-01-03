<%--
  Created by IntelliJ IDEA.
  User: 康小羽的电小脑
  Date: 2021/1/2
  Time: 8:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <c:forEach items="${student}" var="i">
            <tr>
                <td>${i.num}</td>
                <td>${i.name}</td>
                <td>${i.sex}</td>
                <td>${i.major}</td>
                <td>${i.stuClass}</td>
                <td>${i.password}</td>
                <td class="td-manage">
                        <%--           ！！！                     未知--%>
                    <a title="修改" onclick="location.reload()" href="UpdateStudentServlet?stuNum=${i.num}">
                        <i class="layui-icon">&#xe63c;</i></a>
                        <%--           ！！！                     这有个可能发生的错误--%>
                    <a title="删除" onclick="location.reload()" href="DelStudentServlet?stuNum=${i.num}">
                        <i class="layui-icon">&#xe640;</i></a>
                </td>
            </tr>
        </c:forEach>
</body>
</html>
