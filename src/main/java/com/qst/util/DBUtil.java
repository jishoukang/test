package com.qst.util;

import com.qst.bean.*;
import org.apache.commons.beanutils.BeanUtils;

import javax.sql.DataSource;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class DBUtil {

    private static final String DriverName = "com.mysql.cj.jdbc.Driver";   // MySQL驱动程序
    private static final String DBUrl = "jdbc:mysql://localhost:3306/es?useSSL=true&serverTimezone=GMT";   // 数据库连接地址
    private static final String DBUsername = "root";   // 用户名
    private static final String DBPassword = "12345";   // 密码
    // 获取连接对象
    public static Connection getConnection() throws Exception {
        // 加载数据库驱动程序
        Class.forName(DriverName);
        return DriverManager.getConnection(DBUrl, DBUsername, DBPassword);
    }

    // 类型参数，类型变量，类型是可以变化
    public static <T> List<T> getList(Class<T> clazz, String sql, Object... args)  {

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        List<T> userList = null;

        try {
            // 获取数据库连接对象
            conn = DBUtil.getConnection();

            // 预编译SQL语句
            ps = conn.prepareStatement(sql);

            // 如果有条件参数
            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; ++i) {
                    ps.setObject(i + 1, args[i]);
                }
            }

            // 执行查询，获取结果集
            rs = ps.executeQuery();

            // 获取结果集元数据
            ResultSetMetaData rsmd = rs.getMetaData();

            //获取当前结果集的列数
            int colnum = rsmd.getColumnCount();

            //开辟空间
            userList = new ArrayList<T>();

            while (rs.next()) {
                // key存放列名，value存放列值，for循环完成之后rowMap存放了一条记录
                Map<String, Object> rowMap = new HashMap<String, Object>();

                for (int i = 1; i <= colnum; i++) {
                    String columnName = rsmd.getColumnLabel(i);
                    Object columnValue = rs.getObject(columnName);

                    // 判断查询出来的类的类型，如果是java.sql.Date转成java.util.Date
                    if (columnValue instanceof Date) {
                        Date date = (Date) columnValue;
                        columnValue = new java.util.Date(date.getTime());
                    }
                    rowMap.put(columnName, columnValue);
                }
                //创建一个User对象，给这个User对象赋值
                T bean = clazz.newInstance();

                //根据列名给类属性赋值  "set" + 属性名("set" + Id)
                //循环rowMap给User所有属性赋值
                for (Map.Entry<String, Object> entry : rowMap.entrySet()) {

                    String propertyName = entry.getKey();
                    Object propertyValue = entry.getValue();

                    //获取propertyName属性赋值的set方法
                    String methodName = "set" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);

                    //对象获取自己对应的字节码文件
                    Method method = clazz.getMethod(methodName, propertyValue.getClass());

                    //调用方法给属性赋值
                    method.invoke(bean, propertyValue);
                }
                userList.add(bean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            close(conn, ps, rs);
        }
        return userList;
    }

    public static void close(Connection conn, Statement ps, ResultSet rs){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    //    保存对象方法
    public static boolean save(String sql, Object... args)  {

        Connection conn = null;
        PreparedStatement pstate = null;
        Integer count= null;

        try {
            // 获取数据库连接对象
            conn = DBUtil.getConnection();

            // 预编译SQL语句
            pstate = conn.prepareStatement(sql);

            // 如果有条件参数
            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; ++i) {
                    pstate.setObject(i + 1, args[i]);
                }
            }

            // 返回更新的记录数
            count = pstate.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            close(conn, pstate, null);
        }
        return count != null && count > 0 ? true : false;
    }

    public static <T> T getSingleObj(Class<T> clazz, String sql, Object...args){

        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        T bean=null;
        try{
            conn= DBUtil.getConnection();
            ps = conn.prepareStatement(sql);

            if(args!=null&&args.length>0) {
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i + 1, args[i]);

                }
            }
            rs = ps.executeQuery();

            //获取结果集元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            //获取当前结果集的列数
            int colsnum = rsmd.getColumnCount();

            while (rs.next()){

                //key存放列名，value存放列值，for循环完成之后，rowmap存放了一条记录
                Map<String,Object> rowMap=new HashMap<String,Object>();
                for(int i=1;i<=colsnum;i++){
                    String columnName=rsmd.getColumnLabel(i);
                    Object columnValue=rs.getObject(columnName);
                    //判断查询出来的类的类型，如果是java.sql.Date转成java.util.Date
                    if (columnValue instanceof java.sql.Date){
                        java.sql.Date date = (java.sql.Date)columnValue;
                        columnValue=new Date(date.getTime());
                    }
                    rowMap.put(columnName,columnValue);
                }
                //创建一个User对象，给这个USer对象属性赋值；
                bean=clazz.newInstance();
                for (Map.Entry<String,Object> entry:rowMap.entrySet()){
                    String propertyName = entry.getKey();
                    Object propertyValue=entry.getValue();
                    BeanUtils.setProperty(bean,propertyName,propertyValue);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            close(conn, ps, rs);
        }
        return bean;
    }


    // 查询记录数量
    public static Integer getCount(String sql, Object...args) {

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstate = null;
        Integer count = null;

        try {
            // 获取数据库连接对象
            conn = DBUtil.getConnection();

            // 预编译SQL语句
            pstate = conn.prepareStatement(sql);

            // 如果有条件参数
            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; ++i) {
                    pstate.setObject(i + 1, args[i]);
                }
            }

            // 执行查询，获取结果集
            rs = pstate.executeQuery();

            while (rs.next()) {

                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            close(conn, pstate, rs);
        }
        return count;
    }

    // 更新操作
    public static boolean update(String sql, Object... args)  {

        Connection conn = null;
        PreparedStatement ps = null;
        Integer count = 0;

        try {
            // 获取数据库连接对象
            conn = DBUtil.getConnection();

            // 预编译SQL语句
            ps = conn.prepareStatement(sql);

            // 如果有条件参数
            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; ++i) {

                    // 判断当前类型，是不是java.util.Date，转换成java.sql.Date
                    if(args[i] instanceof java.util.Date){
                        java.util.Date date = (java.util.Date)args[i];
                        // 转换成java.sql.Date
                        args[i] = new Date(date.getTime());
                    }

                    ps.setObject(i + 1, args[i]);
                }
            }

            count = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            close(conn, ps, null);
        }
        return count>0?true:false;
    }

    // 更新操作
    public static Integer updateForPrimary(String sql, Object... args)  {

        Connection conn = null;
        PreparedStatement ps = null;
        Integer primaryKey = null;
        ResultSet rs = null;

        try {
            // 获取数据库连接对象
            conn = DBUtil.getConnection();

            // 预编译SQL语句
            ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

            // 如果有条件参数
            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; ++i) {

                    // 判断当前类型，是不是java.util.Date，转换成java.sql.Date
                    if(args[i] instanceof java.util.Date){
                        java.util.Date date = (java.util.Date)args[i];
                        // 转换成java.sql.Date
                        args[i] = new Date(date.getTime());
                    }

                    ps.setObject(i + 1, args[i]);
                }
            }

            ps.executeUpdate();

            rs = ps.getGeneratedKeys();

            if(rs.next()){
                primaryKey = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            close(conn, ps, rs);
        }
        return primaryKey;
    }
        public static List<Employee> selectEmployee(String sql) throws Exception {
            List<Employee> employees = new ArrayList<>();
            Connection connection= null;
            PreparedStatement ps = null;
            connection = DBUtil.getConnection();
            ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Employee employee = new Employee();
                employee.setId(rs.getString("id"));
                employee.setUsername(rs.getString("username"));
                employee.setAccount(rs.getString("account"));
                employee.setPassword(rs.getString("password"));
                employee.setSex(rs.getString("sex"));
                employee.setDepartment(rs.getString("department"));
                employee.setTelephone(rs.getString("telephone"));
                employees.add(employee);
            }
            return employees;
        }
    public static List<Salary> selectSalary(String sql) throws Exception {
        List<Salary> salaries = new ArrayList<>();
        Connection connection= null;
        PreparedStatement ps = null;
        connection = DBUtil.getConnection();
        ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Salary salary = new Salary();
            salary.setId(rs.getString("id"));
            salary.setUsername(rs.getString("username"));
            salary.setDepartment(rs.getString("department"));
            salary.setBase_salary(rs.getDouble("base_salary"));
            salary.setAttendance_day(rs.getInt("attendance_day"));
            salary.setAttendance_salary(rs.getDouble("attendance_salary"));
            salary.setOvertime_salary(rs.getDouble("overtime_salary"));
            salary.setNight_differential(rs.getDouble("night_differential"));
            salary.setAttendance_bonus(rs.getDouble("attendance_bonus"));
            salary.setWithhold(rs.getDouble("withhold"));
            salary.setInsurance(rs.getDouble("insurance"));
            salary.setActual_salary(rs.getDouble("actual_salary"));
            salaries.add(salary);
        }
        return salaries;
    }
    public static List<Gv_Salary> selectGvSalary(String sql) throws Exception {
        List<Gv_Salary> gv_salaries = new ArrayList<>();
        Connection connection= null;
        PreparedStatement ps = null;
        connection = DBUtil.getConnection();
        ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Gv_Salary gv_salary = new Gv_Salary();
            gv_salary.setId(rs.getString("id"));
            gv_salary.setUsername(rs.getString("username"));
            gv_salary.setDepartment(rs.getString("department"));
            gv_salary.setActual_salary(rs.getDouble("actual_salary"));
            gv_salary.setGv_date(rs.getDate("gv_date"));
            gv_salary.setInspro(rs.getDouble("inspro"));
            gv_salary.setCard_no(rs.getString("card_no"));
            gv_salaries.add(gv_salary);
        }
        return gv_salaries;
    }
    public static List<Info_Total> selectInfo_Total(String sql) throws Exception {
        List<Info_Total> info_totals = new ArrayList<>();
        Connection connection= null;
        PreparedStatement ps = null;
        connection = DBUtil.getConnection();
        ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Info_Total info_total = new Info_Total();
            info_total.setMonth(rs.getInt("month"));
            info_total.setDepartment(rs.getString("department"));
            info_total.setBasic_salary(rs.getDouble("basic_salary"));
            info_total.setPost_salary(rs.getDouble("post_salary"));
            info_total.setBonus(rs.getDouble("bonus"));
            info_total.setWithhold(rs.getDouble("withhold"));
            info_total.setTotal(rs.getDouble("total"));
            info_totals.add(info_total);
        }
        return info_totals;
    }
    public static List<Information> selectInformation(String sql) throws Exception {
        List<Information> informations = new ArrayList<>();
        Connection connection= null;
        PreparedStatement ps = null;
        connection = DBUtil.getConnection();
        ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Information information = new Information();
            information.setId(rs.getString("id"));
            information.setUsername(rs.getString("username"));
            information.setDepartment(rs.getString("department"));
            information.setContent(rs.getString("content"));
            information.setDate(rs.getDate("date"));
            informations.add(information);
        }
        return informations;
    }
    public static boolean delete(String sql, Object ...args) {
        Connection conn = null;
        PreparedStatement ps = null;
        Integer count = null;

        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);

            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i + 1, args[i]);
                }
            }
            //返回更新的记录数
            count = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
        return count!=null&&count>0?true:false;
    }

}
