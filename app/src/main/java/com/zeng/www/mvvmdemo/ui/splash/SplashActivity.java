package com.zeng.www.mvvmdemo.ui.splash;

import android.os.Bundle;

import com.zeng.www.mvvmdemo.BR;
import com.zeng.www.mvvmdemo.R;
import com.zeng.www.mvvmdemo.databinding.ActivitySplashBinding;
import com.zeng.www.mvvmdemo.ui.base.BaseActivity;
import com.zeng.www.mvvmdemo.ui.login.LoginActivity;
import com.zeng.www.mvvmdemo.ui.main.MainActivity;

import javax.inject.Inject;

/**
 * @author 曾建雄
 */

public class SplashActivity extends BaseActivity<ActivitySplashBinding, SplashViewModel> implements SplashNavigator {

    @Inject
    SplashViewModel mSplashViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSplashViewModel.setNavigator(this);
        mSplashViewModel.startNextActivity();

    }

    @Override
    protected int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    protected SplashViewModel getViewModel() {
        return mSplashViewModel;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void openLoginActivity() {
        startActivity(LoginActivity.getStartIntent(this));
        finish();
    }

    @Override
    public void openMainActivity() {

        startActivity(MainActivity.getStartIntent(this));
        finish();
    }
}
