package com.qst.servlet;

import com.qst.bean.Gv_Salary;
import com.qst.bean.Salary;
import com.qst.dao.SalaryDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/SalaryGvSearchServlet")
public class SalaryGvSearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //从前台获取id
        String id = request.getParameter("id");
        SalaryDAO salaryDAO=new SalaryDAO();
        try {
            List<Gv_Salary> gv_salary=salaryDAO.SingleGvSalaryList(id);
            //信息放入请求作用域，在主页面展示该对象信息
            request.setAttribute("gv_salary",gv_salary);
            // 请求转发到主页面
            request.getRequestDispatcher("salary_give_manage.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
