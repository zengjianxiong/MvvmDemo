package com.zeng.www.mvvmdemo.ui.main;

import android.databinding.ObservableField;

import com.zeng.www.mvvmdemo.data.DataManager;
import com.zeng.www.mvvmdemo.ui.base.BaseViewModel;
import com.zeng.www.mvvmdemo.utils.rx.SchedulerProvider;

/**
 * description:Data：2018/1/18-16:27
 *
 * @author admin
 */

public class MainViewModel extends BaseViewModel<MainNavigator> {

    private ObservableField<String> appVersion = new ObservableField<>();
    private ObservableField<String> url = new ObservableField<>();

    public MainViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void setAppVersion(String version) {
        appVersion.set(version);
    }

    public ObservableField<String> getAppVersion() {
        return appVersion;
    }
}
