package com.qst.servlet;

import com.qst.dao.EmployeeDAO;
import com.qst.dao.SalaryDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/SalaryUpdateServlet")
public class SalaryUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // 获取前台提交修改的工资信息
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
        // 从session中取出用户ID
        Object slyID = request.getSession().getAttribute("SESSION_salaryID");
        //根据ID修改用户信息
        SalaryDAO salaryDAO=new SalaryDAO();
        boolean flag=salaryDAO.UpdateSalaryById(basic_salary1,attendance_day1,attendance_salary1,overtime_salary1,night_differential1,attendance_bonus1,withhold1,insurance1,actual_salary1,slyID.toString());
        // 请求转发到主页面
        request.getRequestDispatcher("salary_info_manage.jsp").forward(request,response);
    }
}
