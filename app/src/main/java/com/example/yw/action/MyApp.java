package com.example.yw.action;

import android.app.Application;
import android.content.Intent;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * Created by jack
 * On 18-1-30:下午1:31
 * Desc:
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Logger.addLogAdapter(new AndroidLogAdapter());

    }
}
