package com.zeng.www.mvvmdemo.data.local.db;

import com.zeng.www.mvvmdemo.data.AppDataManager;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * description:Data：2018/1/15-14:34
 *
 * @author admin
 */
@Singleton
public class AppDbHelper implements DbHelper {
    private  AppDatabase mAppDatabase;

    @Inject
    public AppDbHelper(AppDatabase appDatabase) {
        this.mAppDatabase = appDatabase;
    }
}
