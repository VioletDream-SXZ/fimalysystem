package com.ysq.model;

public class User {
    private int id;
    private String name;
    private String password;
    private String familyName;

    public User(int id, String name, String password, String familyName) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.familyName = familyName;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFamilyName() {
        return this.familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String toString() {
        return "id:" + this.id + " name:" + this.name + " password:" + this.password + " familyname:" + this.familyName;
    }
}
