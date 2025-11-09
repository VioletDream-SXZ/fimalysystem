package com.ysq.model;

public class UserBuilder {
    private int id;
    private String username;
    private String password;
    private String familyName;

    public UserBuilder() {
        this.id = -1;
        this.username = "";
        this.password = "";
        this.familyName = "";
    }

    public UserBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public UserBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder setFamilyName(String familyName) {
        this.familyName = familyName;
        return this;
    }

    public User build() {
        return new User(this.id, this.username, this.password, this.familyName);
    }
}
