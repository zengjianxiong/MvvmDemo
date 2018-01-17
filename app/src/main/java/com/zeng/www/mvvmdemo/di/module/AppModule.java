package com.zeng.www.mvvmdemo.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.zeng.www.mvvmdemo.BuildConfig;
import com.zeng.www.mvvmdemo.R;
import com.zeng.www.mvvmdemo.data.AppDataManager;
import com.zeng.www.mvvmdemo.data.DataManager;
import com.zeng.www.mvvmdemo.data.local.db.AppDatabase;
import com.zeng.www.mvvmdemo.data.local.db.AppDbHelper;
import com.zeng.www.mvvmdemo.data.local.db.DbHelper;
import com.zeng.www.mvvmdemo.data.local.prefs.AppPreferencesHelper;
import com.zeng.www.mvvmdemo.data.local.prefs.PreferencesHelper;
import com.zeng.www.mvvmdemo.data.remote.ApiHeader;
import com.zeng.www.mvvmdemo.data.remote.ApiHelper;
import com.zeng.www.mvvmdemo.data.remote.AppApiHelper;
import com.zeng.www.mvvmdemo.di.ApiInfo;
import com.zeng.www.mvvmdemo.di.DatabaseInfo;
import com.zeng.www.mvvmdemo.di.PreferenceInfo;
import com.zeng.www.mvvmdemo.utils.AppConstants;
import com.zeng.www.mvvmdemo.utils.rx.AppSchedulerProvider;
import com.zeng.www.mvvmdemo.utils.rx.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * description:Data：2018/1/11-16:35
 *
 * @author admin
 */

@Module
public class AppModule {


    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.API_KEY;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    AppDatabase provideAppDatabase(@DatabaseInfo String dbName, Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, dbName).fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }


    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(@ApiInfo String apiKey,
                                                           PreferencesHelper preferencesHelper) {
        return new ApiHeader.ProtectedApiHeader(
                apiKey,
                preferencesHelper.getCurrentUserId(),
                preferencesHelper.getAccessToken());
    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }
}
