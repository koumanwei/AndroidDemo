package com.koumanwei.androiddemo.mvp.view;

import com.koumanwei.androiddemo.mvp.bean.User;

/**
 * 2017-04-25 下午5:34
 *
 * @author koumanwei
 * @version 1.0
 */
// View层：
// 负责显示数据、提供友好界面跟用户交互就行。MVP下Activity和Fragment以及View的子类体现在了这一 层，
// Activity一般也就做加载UI视图、设置监听再交由Presenter处理的一些工作，
// 所以也就需要持有相应Presenter的引用。本层所需要做的操作就是在每一次有相应交互的时候，
// 调用presenter的相关方法就行。（比如说，button点击）

// 总结下，对于View的接口，去观察功能上的操作，然后考虑：
// 该操作需要什么？（getUserName, getPassword）
// 该操作的结果，对应的反馈？(toMainActivity, showFailedError)
// 该操作过程中对应的友好的交互？(showLoading, hideLoading)
public interface LoginView {
    String getUsername();

    String getPassword();

    void clearUsername();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();
}

