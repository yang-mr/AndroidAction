package com.yw.yw.action;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by jack
 * On 18-1-30:下午1:31
 * Desc:
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
        Logger.addLogAdapter(new AndroidLogAdapter());
    }
}
