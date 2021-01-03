package com.qst.dao;

import com.qst.bean.Employee;
import com.qst.bean.Information;
import com.qst.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDAO {
    public EmployeeDAO(){

    }

    // 保存注册对象
    public boolean saveEmployee(Employee emp) {
        String sql = "insert into employee(ID,USERNAME,ACCOUNT,PASSWORD,SEX,DEPARTMENT,TELEPHONE)" +
                "values(?,?,?,?,?,?,?)";
//        System.out.println(sql+"\t"+emp.getId());

        return DBUtil.save(sql,emp.getId(),emp.getUsername(),emp.getAccount(),emp.getPassword(),emp.getSex(),emp.getDepartment(),emp.getTelephone());
    }

    // 根据email和密码查询用户
    public Employee getEmployeeByAccountAndPass(String account, String password) {

        String sql = "select ID id,USERNAME username,ACCOUNT account,PASSWORD password,SEX sex,DEPARTMENT department,TELEPHONE telephone from employee where ACCOUNT=? and PASSWORD=?";
        return DBUtil.getSingleObj(Employee.class,sql,account,password);
    }

    public Integer selectEmployeeAccountCount(String employeeId) {

        String sql = "select count(*) from employee a where a.ID = ?";
        Integer count = DBUtil.getCount(sql,employeeId);
        return count;
    }

    // 判断当前用户是否有账号
    public Integer isExistResume(Integer employeeId) {

        String sql = "select ID from user b where b.ID = ?";
        Integer resumeID = DBUtil.getCount(sql,employeeId);
        return resumeID;
    }

    //根据账号密码修改信息
    public boolean updateEmployee(Object id,String password){
        String sql = "UPDATE employee SET PASSWORD=? WHERE ID=?";
        boolean flag=DBUtil.update(sql,password,id);
        return flag;
    }

    // 根据id查询用户
    public Employee getEmployeeById(String id) {

        String sql = "select ID id,USERNAME username,ACCOUNT account,PASSWORD password,SEX sex,DEPARTMENT department,TELEPHONE telephone from employee where ID=?";
        return DBUtil.getSingleObj(Employee.class,sql,id);
    }
    //显示所有用户
    public static List<Employee> EmployeeList() throws Exception {
        String sql="select * from employee";
        List<Employee> employee=DBUtil.selectEmployee(sql);
        return employee;
    }
    //根据查询到的id显示用户信息
    public Employee getEmployeeinfoById(String id) {
        String sql = "select ID id,USERNAME username,ACCOUNT account,PASSWORD password,SEX sex,DEPARTMENT department from employee where ID=?";
        return DBUtil.getSingleObj(Employee.class,sql,id);
    }
    //显示单个用户
    public static List<Employee> SingleEmployeeList(String id) throws Exception {
        String sql="select * from employee where id='"+id+"'";
        List<Employee> employee=DBUtil.selectEmployee(sql);
        return employee;
    }
    //删除用户
    public boolean DeleteEmployee(String id){
        String sql="delete from employee where id=?";
        return DBUtil.delete(sql,id);
    }
    // 根据id修改用户
    public boolean UpdateEmployeeById(String username,String account,String password,String sex,String department,String telephone,String id) {

        String sql = "UPDATE employee SET USERNAME=?,ACCOUNT=?,PASSWORD=?,SEX=?,DEPARTMENT=?,TELEPHONE=? WHERE ID=?";
        boolean flag=DBUtil.update(sql,username,account,password,sex,department,telephone,id);
        return flag;
    }

}

