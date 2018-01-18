package com.zeng.www.mvvmdemo.ui.splash;

import com.zeng.www.mvvmdemo.data.DataManager;
import com.zeng.www.mvvmdemo.ui.login.LoginViewModel;
import com.zeng.www.mvvmdemo.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

/**
 * description:Data：2018/1/15-10:58
 *
 * @author admin
 */

@Module
public class SplashActivityModule {

    @Provides
    SplashViewModel provideLoginViewModel(DataManager dataManager,
                                          SchedulerProvider schedulerProvider) {
        return new SplashViewModel(dataManager, schedulerProvider);
    }
}
