package com.yw.yw.action.eventbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yw.yw.action.R;

import org.greenrobot.eventbus.EventBus;

public class SubscriberActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscriber);

        EventBus.getDefault().post(new MessageEvent("我是发送的事件"));
    }
}
