package com.qst.servlet;

import com.qst.bean.Gv_Salary;
import com.qst.bean.Information;
import com.qst.dao.EmployeeDAO;
import com.qst.dao.SalaryDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/SalaryGvServlet")
public class SalaryGvServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        SalaryDAO salaryDAO=new SalaryDAO();
        try {
            List<Gv_Salary> gv_salaries=salaryDAO.GvSalaryList();
            request.setAttribute("gv_salary",gv_salaries);
            request.getRequestDispatcher("salary_give_manage.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
