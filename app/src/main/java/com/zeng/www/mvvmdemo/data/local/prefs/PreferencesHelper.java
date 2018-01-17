package com.zeng.www.mvvmdemo.data.local.prefs;

import com.zeng.www.mvvmdemo.data.DataManager;

/**
 * description:Data：2018/1/12-11:25
 *
 * @author admin
 */

public interface PreferencesHelper {
    int getCurrentUserLoggedInMode();

    void setCurrentUserLoggedInMode(DataManager.LoggedInMode mode);

    Long getCurrentUserId();

    void setCurrentUserId(Long userId);

    String getAccessToken();

    void setAccessToken(String accessToken);

    String getCurrentUserName();

    void setCurrentUserName(String userName);

    String getCurrentUserEmail();

    void setCurrentUserEmail(String email);

    String getCurrentUserProfilePicUrl();

    void setCurrentUserProfilePicUrl(String profilePicUrl);
}
