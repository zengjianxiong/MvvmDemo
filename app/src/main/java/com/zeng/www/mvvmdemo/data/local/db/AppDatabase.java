package com.zeng.www.mvvmdemo.data.local.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.zeng.www.mvvmdemo.data.local.db.dao.UserDao;
import com.zeng.www.mvvmdemo.data.model.db.User;

/**
 * description:Data：2018/1/15-14:23
 *
 * @author admin
 */
@Database(version = 1, entities = {User.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao mUserDao();
}
