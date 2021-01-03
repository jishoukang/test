package com.qst.bean;

public class Info_Total {
    private int month;
    private String department;
    private double basic_salary;
    private double post_salary;
    private double bonus;
    private double withhold;
    private double total;

    public Info_Total() {
    }

    public Info_Total(int month, String department, double basic_salary, double post_salary, double bonus, double withhold, double total) {
        this.month = month;
        this.department = department;
        this.basic_salary = basic_salary;
        this.post_salary = post_salary;
        this.bonus = bonus;
        this.withhold = withhold;
        this.total = total;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setBasic_salary(double basic_salary) {
        this.basic_salary = basic_salary;
    }

    public void setPost_salary(double post_salary) {
        this.post_salary = post_salary;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void setWithhold(double withhold) {
        this.withhold = withhold;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getMonth() {
        return month;
    }

    public String getDepartment() {
        return department;
    }

    public double getBasic_salary() {
        return basic_salary;
    }

    public double getPost_salary() {
        return post_salary;
    }

    public double getBonus() {
        return bonus;
    }

    public double getWithhold() {
        return withhold;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Info_Total{" +
                "month=" + month +
                ", department='" + department + '\'' +
                ", basic_salary=" + basic_salary +
                ", post_salary=" + post_salary +
                ", bonus=" + bonus +
                ", withhold=" + withhold +
                ", total=" + total +
                '}';
    }
}
