package com.qst.servlet;

import com.qst.bean.Employee;
import com.qst.bean.User;
import com.qst.dao.AdminDAO;
import com.qst.dao.EmployeeDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/EmployeeInfoServlet")
public class EmployeeInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        EmployeeDAO employeeDAO=new EmployeeDAO();
        try {
                List<Employee> employees=EmployeeDAO.EmployeeList();
                request.setAttribute("employee",employees);
                request.getRequestDispatcher("employee_info_manage.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
