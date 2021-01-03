package com.qst.servlet;

import com.qst.bean.Employee;
import com.qst.dao.EmployeeDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/PwdChangeServlet")
public class PwdChangeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // 获取前台提交的密码
        String password = request.getParameter("password");

        // 从session中取出简历ID
        Object resumeID = request.getSession().getAttribute("SESSION_employeeID");
        // 根据id和密码查询申请人
        EmployeeDAO employeeDAO = new EmployeeDAO();
        boolean flag=employeeDAO.updateEmployee(resumeID,password);


        if(flag!=false){
            //通过response对象给客户端一个错误提示
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write(" alert('密码修改成功,请重新登录!!');");
            writer.write("window.location.href='employee_login.jsp'");
            writer.write("</script>");
            writer.flush();
            writer.close();
//            // 请求转发到主页面
//            request.getRequestDispatcher("employee_login.jsp").forward(request,response);
        }
        else{
            //通过response对象给客户端一个错误提示
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write(" alert('修改失败!！');");
            writer.write("window.location.href='password_change.jsp'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
