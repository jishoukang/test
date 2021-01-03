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

@WebServlet(urlPatterns = "/EmployeeSearchServlet")
public class EmployeeSearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //从前台获取id
        String id = request.getParameter("id");
        EmployeeDAO employeeDAO=new EmployeeDAO();
        try {
            List<Employee> employee=employeeDAO.SingleEmployeeList(id);
            //信息放入请求作用域，在主页面展示该对象信息
            request.setAttribute("employee",employee);
            // 请求转发到主页面
            request.getRequestDispatcher("employee_info_manage.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
