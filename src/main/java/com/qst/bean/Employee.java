package com.qst.bean;

import java.util.Random;

public class Employee {
    private String id;
    private String username;
    private String account;
    private String password;
    private String sex;
    private String department;
    private String telephone;

    public  Employee(){

    }

    public Employee(String id, String username, String account, String password, String sex, String department, String telephone) {
        this.id = id;
        this.username = username;
        this.account = account;
        this.password = password;
        this.sex = sex;
        this.department = department;
        this.telephone = telephone;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public String getSex() {
        return sex;
    }

    public String getDepartment() {
        return department;
    }

    public String getTelephone() {
        return telephone;
    }

    /**
     * 获取手机头3位
     * @param type
     * @return
     */
    public static String getHeadMobile(Integer type){
        switch (type) {
            case 1:
                return "130";
            case 2:
                return "131";
            case 3:
                return "132";
            case 4:
                return "133";
            case 5:
                return "134";
            case 6:
                return "135";
            case 7:
                return "136";
            case 8:
                return "137";
            case 9:
                return "138";
            case 10:
                return "139";
            case 11:
                return "150";
            case 12:
                return "151";
            case 13:
                return "152";
            case 14:
                return "153";
            case 15:
                return "155";
            case 16:
                return "156";
            case 17:
                return "157";
            case 18:
                return "158";
            case 19:
                return "159";
            case 20:
                return "177";
            case 21:
                return "186";
            case 22:
                return "183";
            case 23:
                return "187";
            case 24:
                return "188";
            case 25:
                return "189";
            default:
                return "173";
        }
    }
    /**
     * 获取尾号4位
     * @return
     */
    public static String getEndMobile(){
        String ychar = "0,1,2,3,4,5,6,7,8,9";
        int wei = 4;
        String[] ychars = ychar.split(",");
        String endMobile = "";
        Random rdm = new Random();
        for (int i = 0; i < wei; i++) {
            int j = (rdm.nextInt() >>> 1) % 10;
            if (j > 10) {
                j = 0;
            }
            endMobile = endMobile + ychars[j];
        }
        return endMobile;

    }
    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", department='" + department + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
