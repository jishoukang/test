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
import java.util.List;
@WebServlet(urlPatterns = "/SalaryManageServlet")
public class SalaryManageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        SalaryDAO salaryDAO=new SalaryDAO();
        try {
            List<Salary> salaries=salaryDAO.SalaryList();
            System.out.println(salaries);
            request.setAttribute("salary",salaries);
            request.getRequestDispatcher("salary_info_manage.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
