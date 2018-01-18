package com.zeng.www.mvvmdemo.ui.main;

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
public class MainActivityModule {

    @Provides
    MainViewModel provideMainViewModel(DataManager dataManager,
                                       SchedulerProvider schedulerProvider) {
        return new MainViewModel(dataManager, schedulerProvider);
    }
}
