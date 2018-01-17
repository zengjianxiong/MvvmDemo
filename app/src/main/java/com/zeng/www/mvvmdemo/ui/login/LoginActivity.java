package com.zeng.www.mvvmdemo.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;


import com.zeng.www.mvvmdemo.BR;
import com.zeng.www.mvvmdemo.R;
import com.zeng.www.mvvmdemo.databinding.ActivityLoginBinding;
import com.zeng.www.mvvmdemo.ui.base.BaseActivity;
import com.zeng.www.mvvmdemo.ui.main.MainActivity;

import javax.inject.Inject;


/**
 * 登录activity
 *
 * @author 大雄
 */
public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginViewModel> implements LoginNavigator {


    @Inject
    LoginViewModel mLoginViewModel;

    ActivityLoginBinding mActivityLoginBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityLoginBinding = getViewDataBinding();
        mLoginViewModel.setNavigator(this);
    }

    @Override
    protected int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    protected LoginViewModel getViewModel() {
        return mLoginViewModel;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    public static Intent getStartIntent(Context context) {
        return new Intent(context, LoginActivity.class);
    }

    @Override
    public void login() {


        if (mLoginViewModel.isEmailAndPasswordValid(getEmail(), getPassword())) {

            mLoginViewModel.login(getEmail(), getPassword());
        } else {
            Toast.makeText(this, getString(R.string.invalid_email_password), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void handleError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void openMainActivity() {
        Intent intent = MainActivity.getStartIntent(LoginActivity.this);
        startActivity(intent);
        finish();
    }

    private String getPassword() {
        return mActivityLoginBinding.etPassword.getText().toString();
    }

    private String getEmail() {
        return mActivityLoginBinding.etEmail.getText().toString();
    }
}
