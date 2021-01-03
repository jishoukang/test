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

@WebServlet(urlPatterns = "/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        // 获取前台提交的账号和密码
        String account = request.getParameter("account");
        String password = request.getParameter("password");

        // 根据account和密码查询申请人
        AdminDAO adminDAO = new AdminDAO();
        User admin = adminDAO.getAdminByAccountAndPass(account, password);
        EmployeeDAO employeeDAO=new EmployeeDAO();
        try {
            List<Employee> employees=EmployeeDAO.EmployeeList();

            if(admin!=null){
                System.out.println(employees);
                request.setAttribute("employee",employees);
                request.getRequestDispatcher("employee_info_manage.jsp").forward(request,response);
//                response.sendRedirect("/test_war_exploded/employee_info_manage.jsp");
            }
            else{
                //通过response对象给客户端一个错误提示
                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write(" alert('账号或密码错误!！');");
                writer.write("window.location.href='employee_login.jsp'");
                writer.write("</script>");
                writer.flush();
                writer.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
