package com.qst.servlet;

import com.qst.bean.Employee;
import com.qst.dao.EmployeeDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet(urlPatterns = "/EmployeeAddServlet")
public class EmployeeAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // 获取前台提交的账号和密码
        String id=request.getParameter("id");
        String username=request.getParameter("username");
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String sex=request.getParameter("sex");
        String department=request.getParameter("department");
        //随机一个号码
        Integer headRandom=new Random().nextInt(25);
        String mobile = new Employee().getHeadMobile(headRandom) +new Employee().getEndMobile() + new Employee().getEndMobile();
        //插入到数据库中，对数据进行封装，自己封装成一个对象
        Employee employee = new Employee(id, username,account,password,sex,department,mobile);
        //保存applicant到数据库 applicantDAO
        EmployeeDAO employeeDAO=new EmployeeDAO();
//        System.out.println(employee);
        //判断是否有相同的Account
        Integer count = employeeDAO.selectEmployeeAccountCount(account);
        if (count>0){
            //数据库中已经有相同account的用户
            //通过response对象给客户端一个错误提示
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write(" alert('此账号已注册！');");
            writer.write("window.location.href='employee_add.jsp'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }else {
            //flag是否注册成功
            boolean flag = employeeDAO.saveEmployee(employee);
//            System.out.println(flag);
            if (flag) {
                //注册成功就跳转到登录页面 重定向
                response.sendRedirect("/test_war_exploded/employee_info_manage.jsp");
            } else {
                //注册失败就返回注册页面 请求转发
                RequestDispatcher dispatcher = request.getRequestDispatcher("/employee_add.jsp");
                dispatcher.forward(request, response);
            }
        }
    }
}
