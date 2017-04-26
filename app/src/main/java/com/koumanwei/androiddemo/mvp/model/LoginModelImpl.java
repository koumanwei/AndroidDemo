package com.koumanwei.androiddemo.mvp.model;

import android.os.Handler;
import android.os.SystemClock;

import com.koumanwei.androiddemo.mvp.bean.User;

/**
 * 2017-04-25 下午5:26
 *
 * @author koumanwei
 * @version 1.0
 */

public class LoginModelImpl implements LoginModel {
    private Handler mHandler = new Handler();

    @Override
    public void login(final String username, final String password, final OnLoginFinishedListener onLoginFinishedListener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 模拟耗时任务
                SystemClock.sleep(3000);
                if ("koumanwei".equals(username) && "123456".equals(password)) {
                    final User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            onLoginFinishedListener.loginSuccess(user);
                        }
                    });
                } else {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            onLoginFinishedListener.loginFailed();
                        }
                    });
                }
            }
        }).start();
    }
}
