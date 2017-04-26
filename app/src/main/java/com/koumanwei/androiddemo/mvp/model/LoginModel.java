package com.koumanwei.androiddemo.mvp.model;

import com.koumanwei.androiddemo.mvp.bean.User;

/**
 * 2017-04-25 下午5:18
 *
 * @author koumanwei
 * @version 1.0
 */

public interface LoginModel {
    interface OnLoginFinishedListener {
        /**
         * 登陆成功
         */
        void loginSuccess(User user);

        /**
         * 登陆失败
         */
        void loginFailed();
    }

    void login(String username, String password, OnLoginFinishedListener onLoginFinishedListener);
}
