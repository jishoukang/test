package com.qst.servlet;

import com.qst.bean.Employee;
import com.qst.bean.Salary;
import com.qst.dao.EmployeeDAO;
import com.qst.dao.SalaryDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/SalaryViewServlet")
public class SalaryViewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从session中取出简历ID
        Object salaryID = request.getSession().getAttribute("SESSION_salaryID");
        // 根据id和密码查询申请人
        SalaryDAO salaryDAO = new SalaryDAO();
        Salary salary=salaryDAO.getSalaryById(salaryID);
        //信息放入请求作用域，在主页面展示该对象信息
        request.setAttribute("salary",salary);
        // 请求转发到主页面
        request.getRequestDispatcher("salary_view.jsp").forward(request,response);
    }
}
