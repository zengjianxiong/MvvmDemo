package com.zeng.www.mvvmdemo.data;

import com.zeng.www.mvvmdemo.data.local.prefs.PreferencesHelper;
import com.zeng.www.mvvmdemo.data.local.db.DbHelper;
import com.zeng.www.mvvmdemo.data.remote.ApiHelper;

/**
 * description:Data：2018/1/12-11:23
 *
 * @author admin
 */

public interface DataManager extends DbHelper, PreferencesHelper, ApiHelper {


    void updateApiHeader(Long userId, String accessToken);

    void updateUserInfo(String accessToken,
                        Long userId,
                        LoggedInMode loggedInModeServer,
                        String userName,
                        String userEmail,
                        String googleProfilePicUrl);

    enum LoggedInMode {

        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_GOOGLE(1),
        LOGGED_IN_MODE_FB(2),
        LOGGED_IN_MODE_SERVER(3);

        private final int mType;

        LoggedInMode(int type) {
            mType = type;
        }

        public int getType() {
            return mType;
        }
    }
}
