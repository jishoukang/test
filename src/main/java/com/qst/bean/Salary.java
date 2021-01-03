package com.qst.bean;

public class Salary {
    private String id;
    private String username;
    private String department;
    private double base_salary;
    private Integer attendance_day;
    private double attendance_salary;
    private double overtime_salary;
    private double night_differential;
    private double attendance_bonus;
    private double withhold;
    private double insurance;
    private double actual_salary;

    public Salary(){

    }
    public Salary(String id, String username, String department, double base_salary, Integer attendance_day, double attendance_salary, double overtime_salary, double night_differential, double attendance_bonus, double withhold, double insurance, double actual_salary) {
        this.id = id;
        this.username = username;
        this.department = department;
        this.base_salary = base_salary;
        this.attendance_day = attendance_day;
        this.attendance_salary = attendance_salary;
        this.overtime_salary = overtime_salary;
        this.night_differential = night_differential;
        this.attendance_bonus = attendance_bonus;
        this.withhold = withhold;
        this.insurance = insurance;
        this.actual_salary = actual_salary;
    }

//    public Salary(String id, String username, String department, Integer basic_salary1, double attendance_day1, String attendance_salary, String overtime_salary, String night_differential, String attendance_bonus, String withhold, String insurance, String actual_salary) {
//    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setBase_salary(double base_salary) {
        this.base_salary = base_salary;
    }

    public void setAttendance_day(int attendance_day) {
        this.attendance_day = attendance_day;
    }

    public void setAttendance_salary(double attendance_salary) {
        this.attendance_salary = attendance_salary;
    }

    public void setOvertime_salary(double overtime_salary) {
        this.overtime_salary = overtime_salary;
    }

    public void setNight_differential(double night_differential) {
        this.night_differential = night_differential;
    }

    public void setAttendance_bonus(double attendance_bonus) {
        this.attendance_bonus = attendance_bonus;
    }

    public void setWithhold(double withhold) {
        this.withhold = withhold;
    }

    public void setInsurance(double insurance) {
        this.insurance = insurance;
    }

    public void setActual_salary(double actual_salary) {
        this.actual_salary = actual_salary;
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

    public double getBase_salary() {
        return base_salary;
    }

    public int getAttendance_day() {
        return attendance_day;
    }

    public double getAttendance_salary() {
        return attendance_salary;
    }

    public double getOvertime_salary() {
        return overtime_salary;
    }

    public double getNight_differential() {
        return night_differential;
    }

    public double getAttendance_bonus() {
        return attendance_bonus;
    }

    public double getWithhold() {
        return withhold;
    }

    public double getInsurance() {
        return insurance;
    }

    public double getActual_salary() {
        return actual_salary;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", department='" + department + '\'' +
                ", base_salary=" + base_salary +
                ", attendance_day=" + attendance_day +
                ", attendance_salary=" + attendance_salary +
                ", overtime_salary=" + overtime_salary +
                ", night_differential=" + night_differential +
                ", attendance_bonus=" + attendance_bonus +
                ", withhold=" + withhold +
                ", insurance=" + insurance +
                ", actual_salary=" + actual_salary +
                '}';
    }
}
