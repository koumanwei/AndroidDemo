package com.koumanwei.androiddemo.mvp.presenter;

import com.koumanwei.androiddemo.mvp.bean.User;
import com.koumanwei.androiddemo.mvp.model.LoginModel;
import com.koumanwei.androiddemo.mvp.model.LoginModelImpl;
import com.koumanwei.androiddemo.mvp.view.LoginView;

/**
 * 2017-04-26 上午9:21
 *
 * @author koumanwei
 * @version 1.0
 */
// Presenter扮演着view和model的中间层的角色。获取model层的数据之后构建view层；
// 也可以收到view层UI上的反馈命令后分发处理逻辑，交给model层做业务操作。它也可以决定View层的各种操作。
public class LoginPresenterImpl implements LoginPresenter, LoginModel.OnLoginFinishedListener {
    private LoginView loginView;
    private LoginModel loginModel;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginModel = new LoginModelImpl();
    }

    @Override
    public void login() {
        if (loginView != null) {
            loginView.showLoading();
            loginModel.login(loginView.getUsername(), loginView.getPassword(), this);
        }
    }

    @Override
    public void onDestroy() {
        loginView = null;
    }

    @Override
    public void clearUsernameAndPassword() {
        loginView.clearUsername();
        loginView.clearPassword();
    }

    @Override
    public void loginSuccess(User user) {
        if (loginView != null) {
            loginView.hideLoading();
            loginView.toMainActivity(user);
        }
    }

    @Override
    public void loginFailed() {
        if (loginView != null) {
            loginView.showFailedError();
            loginView.hideLoading();
        }
    }
}
