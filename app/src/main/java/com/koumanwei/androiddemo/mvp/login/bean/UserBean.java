package com.koumanwei.androiddemo.mvp.login.bean;

/**
 * 2017-04-27 下午3:24
 *
 * @author koumanwei
 * @version 1.0
 */

public class UserBean {
    private String username;
    private String password;

    public UserBean() {
    }

    public UserBean(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
