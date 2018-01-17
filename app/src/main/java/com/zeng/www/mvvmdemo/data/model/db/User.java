package com.zeng.www.mvvmdemo.data.model.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * description:Data：2018/1/15-14:26
 *
 * @author admin
 */

@Entity(tableName = "users")
public class User {

    @PrimaryKey
    @ColumnInfo(name = "USER_ID")
    private Long id;

    @ColumnInfo(name = "USER_NAME")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
