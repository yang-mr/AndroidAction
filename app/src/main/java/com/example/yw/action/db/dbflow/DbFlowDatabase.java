package com.example.yw.action.db.dbflow;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created on 2018/8/414:03.
 * Author jackyang
 * -------------------------------
 *
 * @description
 * @email 3180518198@qq.com
 */

@Database(name = DbFlowDatabase.NAME, version = DbFlowDatabase.VERSION)
public class DbFlowDatabase {
    //数据库名称
    public static final String NAME = "RuomizDataBase";
    //数据库版本
    public static final int VERSION = 1;
}
