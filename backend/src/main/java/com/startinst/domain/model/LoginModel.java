package com.startinst.domain.model;

/**
 * @author liuyuancheng
 */
public class LoginModel {

    private String username;

    private String password;

    public String getUsername() {
        return username.trim();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password.trim();
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
