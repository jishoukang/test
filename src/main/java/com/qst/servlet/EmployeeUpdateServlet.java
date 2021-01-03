package com.qst.servlet;

import com.qst.bean.Employee;
import com.qst.dao.EmployeeDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/EmployeeUpdateServlet")
public class EmployeeUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // 获取前台提交员工信息
        String username=request.getParameter("username");
        String account=request.getParameter("account");
        String password = request.getParameter("password");
        String sex=request.getParameter("sex");
        String department=request.getParameter("department");
        String telephone=request.getParameter("telephone");
        // 从session中取出用户ID
        Object empID = request.getSession().getAttribute("SESSION_employeeID");
        //根据ID修改用户信息
        EmployeeDAO employeeDAO=new EmployeeDAO();
        boolean flag=employeeDAO.UpdateEmployeeById(username,account,password,sex,department,telephone,empID.toString());
        // 请求转发到主页面
        request.getRequestDispatcher("employee_info_manage.jsp").forward(request,response);

    }
}
