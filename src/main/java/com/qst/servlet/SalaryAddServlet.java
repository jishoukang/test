package com.qst.servlet;

import com.qst.bean.Employee;
import com.qst.bean.Salary;
import com.qst.dao.EmployeeDAO;
import com.qst.dao.SalaryDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet(urlPatterns = "/SalaryAddServlet")
public class SalaryAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // 获取前台提交的账号和密码
        String id=request.getParameter("id");
        String username=request.getParameter("username");
        String department=request.getParameter("department");

        String basic_salary=(request.getParameter("basic_salary"));
        double basic_salary1=Double.valueOf(basic_salary).doubleValue();

        String attendance_day=(request.getParameter("attendance_day"));
        Integer attendance_day1=Integer.valueOf(attendance_day);

        String attendance_salary=request.getParameter("attendance_salary");
        double attendance_salary1=Double.valueOf(attendance_salary).doubleValue();

        String overtime_salary=request.getParameter("overtime_salary");
        double overtime_salary1=Double.valueOf(overtime_salary).doubleValue();

        String night_differential=request.getParameter("night_differential");
        double night_differential1=Double.valueOf(night_differential).doubleValue();

        String attendance_bonus=request.getParameter("attendance_bonus");
        double attendance_bonus1=Double.valueOf(attendance_bonus).doubleValue();

        String withhold=request.getParameter("withhold");
        double withhold1=Double.valueOf(withhold).doubleValue();

        String insurance=request.getParameter("insurance");
        double insurance1=Double.valueOf(insurance).doubleValue();

        String actual_salary=request.getParameter("actual_salary");
        double actual_salary1=Double.valueOf(actual_salary).doubleValue();

        //插入到数据库中，对数据进行封装，自己封装成一个对象
        Salary salary = new Salary(id,username,department,basic_salary1,attendance_day1,attendance_salary1,overtime_salary1,night_differential1,attendance_bonus1,withhold1,insurance1,actual_salary1);
        //保存applicant到数据库 applicantDAO
        SalaryDAO salaryDAO=new SalaryDAO();
        //判断是否有相同的id
        Integer count = salaryDAO.selectSalaryIdCount(id);
        if (count>0){
            //数据库中已经有相同id的用户
            //通过response对象给客户端一个错误提示
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write(" alert('此账号已添加过信息！');");
            writer.write("window.location.href='salary_add.jsp'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }else {
            //flag是否注册成功
            boolean flag = SalaryDAO.saveSalary(salary);
//            System.out.println(flag);
            if (flag) {
                //添加就跳转到信息页面 重定向
                response.sendRedirect("/test_war_exploded/salary_info_manage.jsp");
            } else {
                //注册失败就返回注册页面 请求转发
                RequestDispatcher dispatcher = request.getRequestDispatcher("/salary_add.jsp");
                dispatcher.forward(request, response);
            }
        }
    }
}
