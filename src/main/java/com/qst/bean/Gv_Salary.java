package com.qst.bean;

import java.util.Date;

public class Gv_Salary {
    private String id;
    private String username;
    private String department;
    private double actual_salary;
    private Date gv_date;
    private double inspro;
    private String card_no;

    public Gv_Salary() {
    }

    public Gv_Salary(String id, String username, String department, double actual_salary, Date gv_date, double inspro, String card_no) {
        this.id = id;
        this.username = username;
        this.department = department;
        this.actual_salary = actual_salary;
        this.gv_date = gv_date;
        this.inspro = inspro;
        this.card_no = card_no;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setActual_salary(double actual_salary) {
        this.actual_salary = actual_salary;
    }

    public void setGv_date(Date gv_date) {
        this.gv_date = gv_date;
    }

    public void setInspro(double inspro) {
        this.inspro = inspro;
    }

    public void setCard_no(String card_no) {
        this.card_no = card_no;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getDepartment() {
        return department;
    }

    public double getActual_salary() {
        return actual_salary;
    }

    public Date getGv_date() {
        return gv_date;
    }

    public double getInspro() {
        return inspro;
    }

    public String getCard_no() {
        return card_no;
    }

    @Override
    public String toString() {
        return "Gv_Salary{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", department='" + department + '\'' +
                ", actual_salary=" + actual_salary +
                ", gv_date=" + gv_date +
                ", inspro=" + inspro +
                ", card_no='" + card_no + '\'' +
                '}';
    }
}
