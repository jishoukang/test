package com.qst.servlet;

import com.qst.bean.Gv_Salary;
import com.qst.bean.Info_Total;
import com.qst.dao.SalaryDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/SalaryTotlaServlet")
public class SalaryTotlaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        SalaryDAO salaryDAO=new SalaryDAO();
        try {
            List<Info_Total> info_totals=salaryDAO.TotalSalaryList();
            request.setAttribute("info_total",info_totals);
            request.getRequestDispatcher("salary_statistics.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
