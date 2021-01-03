package com.qst.servlet;

import com.qst.bean.Employee;
import com.qst.bean.Salary;
import com.qst.dao.EmployeeDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/EmployeeLoginServlet")
public class EmployeeLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        // 获取前台提交的账号和密码
        String account = request.getParameter("account");
        String password = request.getParameter("password");


        // 根据account和密码查询申请人
        EmployeeDAO employeeDAO = new EmployeeDAO();
        Employee employee = employeeDAO.getEmployeeByAccountAndPass(account, password);
//        Salary salary=new Salary();
//        salary.setId(employee.getId());
        // 将当前登录用户的建立ID，保存到Session中
        String employeeID=employee.getId();
        String salaryID=employee.getId();
        request.getSession().setAttribute("SESSION_employeeID",employeeID);
        request.getSession().setAttribute("SESSION_salaryID",salaryID);

        if(employee!=null){
            //信息放入请求作用域，在主页面展示该对象信息
            request.setAttribute("employee",employee);
            // 请求转发到主页面
            request.getRequestDispatcher("person_info.jsp").forward(request,response);
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
    }
}