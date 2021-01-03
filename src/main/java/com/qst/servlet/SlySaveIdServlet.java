package com.qst.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/SlySaveIdServlet")
public class SlySaveIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从前台获取id
        String id = request.getParameter("slyId");
        // 将当前登录用户的建立ID，保存到Session中
        String salaryID=id;
        request.getSession().setAttribute("SESSION_salaryID",salaryID);
        // 请求转发到主页面
        request.getRequestDispatcher("salary_update.jsp").forward(request,response);
    }
}
