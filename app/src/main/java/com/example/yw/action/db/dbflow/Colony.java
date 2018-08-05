package com.example.yw.action.db.dbflow;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created on 2018/8/414:06.
 * Author jackyang
 * -------------------------------
 *
 * @description
 * @email 3180518198@qq.com
 */

@Table(database = DbFlowDatabase.class)
public class Colony extends BaseModel {
    @PrimaryKey(autoincrement = true)
    long id;

    @Column
    String name;
}
