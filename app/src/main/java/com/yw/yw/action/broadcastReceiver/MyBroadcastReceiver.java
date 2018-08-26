package com.yw.yw.action.broadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;

import com.yw.yw.action.Utils;
import com.orhanobut.logger.Logger;

/**
 * Created by jack
 * On 18-1-30:下午2:09
 * Desc:
 */

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Logger.d("intent: " + intent);
        Logger.d("netType: " + Utils.getAPNType(context));
    }

    /**
     * other method net change
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
}
