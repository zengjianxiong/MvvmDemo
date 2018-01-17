package com.zeng.www.mvvmdemo.ui.login;

/**
 * description:Data：2018/1/15-10:47
 *
 * @author admin
 */

public interface LoginNavigator {


    /**
     * 登录方法
     */
    void login();

    /**
     * 错误返回
     *
     * @param throwable
     */
    void handleError(Throwable throwable);

    /**
     * 跳转mainactivity
     */
    void openMainActivity();
}
