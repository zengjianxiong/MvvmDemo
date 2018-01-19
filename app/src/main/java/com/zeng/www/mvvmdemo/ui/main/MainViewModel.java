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
    private ObservableField<String> userName = new ObservableField<>();
    private ObservableField<String> userEmail = new ObservableField<>();
    private ObservableField<String> userProfilePicUrl = new ObservableField<>();

    public MainViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }


    public void setAppVersion(String version) {
        appVersion.set(version);
    }

    public ObservableField<String> getAppVersion() {
        return appVersion;
    }

    public ObservableField<String> getUserProfilePicUrl() {
        return userProfilePicUrl;
    }


    public void onNavMenuCreated() {
         String currentUserName = getDataManager().getCurrentUserName();
        if (currentUserName != null && !currentUserName.isEmpty()) {
            userName.set(currentUserName);
        }

        final String currentUserEmail = getDataManager().getCurrentUserEmail();
        if (currentUserEmail != null && !currentUserEmail.isEmpty()) {
            userEmail.set(currentUserEmail);
        }

        String profilePicUrl = getDataManager().getCurrentUserProfilePicUrl();
        if (profilePicUrl != null && !profilePicUrl.isEmpty()) {
            userProfilePicUrl.set(profilePicUrl);
        }
    }

    public ObservableField<String> getUserName() {
        return userName;
    }

    public ObservableField<String> getUserEmail() {
        return userEmail;
    }
}
