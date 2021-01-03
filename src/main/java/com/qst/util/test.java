package com.qst.util;

import com.qst.bean.Employee;
import com.qst.bean.User;
import com.qst.dao.AdminDAO;
import com.qst.dao.EmployeeDAO;

import java.sql.Connection;

public class test {
    public static void main(String[] args) throws Exception {
          //测试数据库是否连接成功
//        Connection conn=DBUtil.getConnection();
//        System.out.println(conn);
        EmployeeDAO employeeDAO = new EmployeeDAO();
        boolean flag=employeeDAO.updateEmployee("1077","1009");
        System.out.println(flag);
    }


}
