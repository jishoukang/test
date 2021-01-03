package com.qst.dao;

import com.qst.bean.Employee;
import com.qst.bean.Gv_Salary;
import com.qst.bean.Info_Total;
import com.qst.bean.Salary;
import com.qst.util.DBUtil;

import java.util.List;

public class SalaryDAO {
    //将工资表的所有信息输出到集合
    public static List<Salary> SalaryList() throws Exception {
        String sql="select * from salary";
        List<Salary> salary= DBUtil.selectSalary(sql);
        return salary;
    }
    //将查到的id的工资信息输出到集合
    public static List<Salary> SingleSalaryList(String id) throws Exception {
        String sql="select * from salary where id='"+id+"'";
        List<Salary> salary= DBUtil.selectSalary(sql);
        return salary;
    }
    //将发放工资表的信息输出到集合
    public static List<Gv_Salary> GvSalaryList() throws Exception {
        String sql="select * from gv_salary";
        List<Gv_Salary> gv_salary= DBUtil.selectGvSalary(sql);
        return gv_salary;
    }
    //将查到的id的工资信息输出到集合
    public static List<Gv_Salary> SingleGvSalaryList(String id) throws Exception {
        String sql="select * from gv_salary where id='"+id+"'";
        List<Gv_Salary> salary= DBUtil.selectGvSalary(sql);
        return salary;
    }

    //将信息统计表的信息输出到集合
    public static List<Info_Total> TotalSalaryList() throws Exception {
        String sql="select * from info_total";
        List<Info_Total> info= DBUtil.selectInfo_Total(sql);
        return info;
    }
    //删除用户
    public boolean DeleteSalary(String id){
        String sql="delete from salary where id=?";
        return DBUtil.delete(sql,id);
    }
    //判断是否有相同的id
    public Integer selectSalaryIdCount(String salaryId) {

        String sql = "select count(*) from salary a where a.ID = ?";
        Integer count = DBUtil.getCount(sql,salaryId);
        return count;
    }
    // 保存添加对象
    public static boolean saveSalary(Salary sly) {
        String sql = "insert into salary(ID,USERNAME,DEPARTMENT,BASE_SALARY,ATTENDANCE_DAY,ATTENDANCE_SALARY,OVERTIME_SALARY,NIGHT_DIFFERENTIAL,ATTENDANCE_BONUS,WITHHOLD,INSURANCE,ACTUAL_SALARY)" +
                "values(?,?,?,?,?,?,?,?,?,?,?,?)";
        return DBUtil.save(sql,sly.getId(),sly.getUsername(),sly.getDepartment(),sly.getBase_salary(),sly.getAttendance_day(),sly.getActual_salary(),sly.getOvertime_salary(),sly.getNight_differential(),sly.getAttendance_bonus(),sly.getWithhold(),sly.getInsurance(),sly.getActual_salary());
    }
    // 根据id修改工资信息
    public boolean UpdateSalaryById(double basic_salary,Integer attendance_day,double attendance_salary,double overtime_salary,double night_differential,double attendance_bonus,double withhold,double insurance,double actual_salary,String id) {

        String sql = "UPDATE salary SET BASE_SALARY=?,ATTENDANCE_DAY=?,ATTENDANCE_SALARY=?,OVERTIME_SALARY=?,NIGHT_DIFFERENTIAL=?,ATTENDANCE_BONUS=?,WITHHOLD=?,INSURANCE=?,ACTUAL_SALARY=? WHERE ID=?";
        boolean flag=DBUtil.update(sql,basic_salary,attendance_day,attendance_salary,overtime_salary,night_differential,attendance_bonus,withhold,insurance,actual_salary,id);
        return flag;
    }
    //根据id查询用户
    public Salary getSalaryById(Object id) {
        String sql = "select ID id,USERNAME username,DEPARTMENT department,BASE_SALARY base_salary,OVERTIME_SALARY overtime_salary,INSURANCE insurance,ACTUAL_SALARY actual_salary from salary where ID=?";
        return DBUtil.getSingleObj(Salary.class,sql,id);
    }

}

