package com.yw.yw.action.broadcastReceiver;

import android.app.IntentService;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.annotation.Nullable;

/**

    7.0 静态注册广播无效, 使用后台服务动态注册广播监听网络变化
 */
public class MyNetChangeService extends IntentService {
    private MyBroadcastReceiver mBroadcastReceiver;

    public MyNetChangeService() {
        super(null);
    }

    /**

     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public MyNetChangeService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        registerReceiver(mBroadcastReceiver = new MyBroadcastReceiver(), new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mBroadcastReceiver != null) {
         // unregisterReceiver(mBroadcastReceiver);
        }
    }
}
