package com.yw.yw.action;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.orhanobut.logger.Logger;

public class NetChangeActivity extends AppCompatActivity {
    private BroadcastReceiver mBroadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_change);

       // registerReceiver(mBroadcastReceiver = new MyBroadcastReceiver(), new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        /**
         * static register  7.0 can not work
         *  <receiver android:name="com.example.yw.action.broadcastReceiver.MyBroadcastReceiver" >
                 <intent-filter>
                 <action android:name="android.net.conn.CONNECTIVITY_CHANGE"></action>
                 </intent-filter>
             </receiver>
         */
        Logger.d("net change receiver...");

        // otherMonitorNet(this);

        String action = "android.net.conn.CONNECTIVITY_CHANGE.textservice";
        Intent intent = new Intent(action);
        intent.setPackage(this.getPackageName());
        startService(intent);
    }

    /**
     * other method net change
     *
     *
     */
    public void otherMonitorNet(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        connectivityManager.requestNetwork(new NetworkRequest.Builder().build(), new ConnectivityManager.NetworkCallback() {
            @Override public void onAvailable(Network network) {
                super.onAvailable(network);
                Logger.d(network.toString());
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mBroadcastReceiver != null) {
            unregisterReceiver(mBroadcastReceiver);
            Logger.d("net change receiver destroy...");
        }
    }
}
