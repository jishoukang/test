package com.qst.bean;

public class User {
    private String id;
    private String account;
    private String password;
    private String admin_name;

    public User(){

    }
    public User(String id, String account, String password, String admin_name) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.admin_name = admin_name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getId() {
        return id;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", admin_name='" + admin_name + '\'' +
                '}';
    }
}
