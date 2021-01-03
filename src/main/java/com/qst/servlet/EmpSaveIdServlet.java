package com.qst.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/EmpSaveIdServlet")
public class EmpSaveIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从前台获取id
        String id = request.getParameter("empId");
        // 将当前登录用户的建立ID，保存到Session中
        String employeeID=id;
        request.getSession().setAttribute("SESSION_employeeID",employeeID);
        // 请求转发到主页面
        request.getRequestDispatcher("employee_update.jsp").forward(request,response);
    }
}
