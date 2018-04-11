package com.example.yw.action;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * 1 一般情况下，我们谈性能优化基本上会从以下几个方面：
 2     App启动速度优化
 3     UI流畅度优化
 4     内存优化
 5     apk瘦身
 6     电量优化

 */
public class OptimizeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_optimize);
    }
}
