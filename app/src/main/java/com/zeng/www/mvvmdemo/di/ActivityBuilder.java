package com.zeng.www.mvvmdemo.di;

import com.zeng.www.mvvmdemo.ui.login.LoginActivity;
import com.zeng.www.mvvmdemo.ui.login.LoginActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * description:Data：2018/1/11-16:49
 *
 * @author admin
 */

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = LoginActivityModule.class)
    abstract LoginActivity bindLoginActivity();
}
