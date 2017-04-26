package com.koumanwei.androiddemo.mvp.presenter;

/**
 * 登陆的Presenter 的接口，实现类为LoginPresenterImpl，完成登陆的验证，以及销毁当前view
 * 2017-04-26 上午9:19
 *
 * @author koumanwei
 * @version 1.0
 */

public interface LoginPresenter {
    void login();

    void onDestroy();

    void clearUsernameAndPassword();
}
