package com.qst.dao;

import com.qst.bean.Employee;
import com.qst.bean.User;
import com.qst.util.DBUtil;

public class AdminDAO {
    public AdminDAO(){

    }

    // 根据email和密码查询用户
    public User getAdminByAccountAndPass(String account, String password) {

        String sql = "select ACCOUNT account,PASSWORD password from user where ACCOUNT=? and PASSWORD=?";
        return DBUtil.getSingleObj(User.class,sql,account,password);
    }

    public Integer selectUserAccountCount(String userAccount) {

        String sql = "select count(*) from user a where a.ACCOUNT = ?";
        Integer count = DBUtil.getCount(sql,userAccount);
        return count;
    }

}
