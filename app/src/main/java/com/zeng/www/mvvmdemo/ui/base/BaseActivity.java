package com.zeng.www.mvvmdemo.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zeng.www.mvvmdemo.ui.login.LoginActivity;
import com.zeng.www.mvvmdemo.utils.NetworkUtils;

import dagger.android.AndroidInjection;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * description:Data：2018/1/12-14:22
 *
 * @author admin
 */

public abstract class BaseActivity<T extends ViewDataBinding, V extends BaseViewModel> extends AppCompatActivity implements BaseFragment.Callback {


    private T mViewDataBinding;

    private V mViewModel;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        performDependencyInjection();
        super.onCreate(savedInstanceState);
        performDataBinding();
    }

    /**
     * 执行数据绑定
     */
    private void performDataBinding() {
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        this.mViewModel = mViewModel == null ? getViewModel() : mViewModel;
        mViewDataBinding.setVariable(getBindingVariable(), mViewModel);
        mViewDataBinding.executePendingBindings();

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        //设置字体
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    /**
     * 请求运行时权限
     *
     * @param permissions 运行是权限数组
     * @param requestCode 请求码
     */
    @TargetApi(Build.VERSION_CODES.M)
    public void requestPermissionsSafely(@NonNull String[] permissions, int requestCode) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode);
        }
    }


    /**
     * 判断是否有权限
     *
     * @param permission 运行是权限
     * @return b
     */
    @TargetApi(Build.VERSION_CODES.M)
    public boolean hasPermissions(String permission) {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
                checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
    }


    public T getViewDataBinding() {
        return mViewDataBinding;
    }

    /**
     * 退出登录 跳转到loginActivity
     */
    public void openActivityOnTokenExpire() {

        startActivity(LoginActivity.getStartIntent(this));
        finish();
    }

    /**
     * 判断网络是否链接
     *
     * @return boolean
     */
    public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkConnected(this);
    }

    /**
     * 获取 Variable
     *
     * @return variable id
     */
    protected abstract int getBindingVariable();

    /**
     * 获取 view model 实例
     *
     * @return view model 实例
     */
    protected abstract V getViewModel();

    /**
     * 获取布局id
     *
     * @return layout resource id
     */
    protected abstract
    @LayoutRes
    int getLayoutId();

    @Override
    public void onFragmentDetached(String tag) {

    }

    @Override
    public void onFragmentAttached() {

    }

    /**
     * 执行依赖注入
     */
    private void performDependencyInjection() {
        AndroidInjection.inject(this);
    }
}
