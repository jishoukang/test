package com.qst.bean;

import java.util.Date;

public class Information {
    private String id;
    private String username;
    private String department;
    private String content;
    private Date date;

    public Information() {
    }

    public Information(String id, String username, String department, String content, Date date) {
        this.id = id;
        this.username = username;
        this.department = department;
        this.content = content;
        this.date = date;
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

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public String getContent() {
        return content;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Information{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", department='" + department + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                '}';
    }
}
