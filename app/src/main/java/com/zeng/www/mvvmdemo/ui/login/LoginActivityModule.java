package com.zeng.www.mvvmdemo.ui.login;

import com.zeng.www.mvvmdemo.data.DataManager;
import com.zeng.www.mvvmdemo.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

/**
 * description:Data：2018/1/15-10:58
 *
 * @author admin
 */

@Module
public class LoginActivityModule {

    @Provides
    LoginViewModel provideLoginViewModel(DataManager dataManager,
                                         SchedulerProvider schedulerProvider) {
        return new LoginViewModel(dataManager, schedulerProvider);
    }
}
