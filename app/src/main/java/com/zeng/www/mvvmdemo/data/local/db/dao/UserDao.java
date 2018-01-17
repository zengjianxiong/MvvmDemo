package com.zeng.www.mvvmdemo.data.local.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.zeng.www.mvvmdemo.data.model.db.User;

import java.util.List;

/**
 * description:Data：2018/1/15-14:32
 *
 * @author admin
 */
@Dao
public interface UserDao {

    @Query("select * from users")
    List<User> loadAllUsers();
}
