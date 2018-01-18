package com.zeng.www.mvvmdemo.ui.splash;

import com.zeng.www.mvvmdemo.data.DataManager;
import com.zeng.www.mvvmdemo.ui.base.BaseViewModel;
import com.zeng.www.mvvmdemo.utils.rx.SchedulerProvider;

/**
 * description:Data：2018/1/18-14:08
 *
 * @author admin
 */

public class SplashViewModel extends BaseViewModel<SplashNavigator> {
    public SplashViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void startSeeding() {

    }

    public void startNextActivity() {
        if (getDataManager().getCurrentUserLoggedInMode() == DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.getType()) {
            getNavigator().openLoginActivity();
        }else {
            getNavigator().openMainActivity();
        }
    }
}
