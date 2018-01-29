package com.example.yw.action.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yw.action.R;

public class RxJavaActivity extends AppCompatActivity {
    /**
     * switch thread
     *      subscribeOn
     *      observeOn
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);
    }
}
