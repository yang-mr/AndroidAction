package com.example.yw.action.handler;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.yw.action.R;

public class HandlerDemoActivity extends AppCompatActivity {
    private TextView mTv;

    private Handler mHander = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            // 处理接收的消息
            if (msg.what == 1) {
                String content = msg.getData().getString("content");
                mTv.setText(content);

            }
            return false;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_demo);

        mTv = findViewById(R.id.tv_test_handler);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 模拟处理数据
                    Thread.sleep(2000);

                    // 处理完数据更新ui界面
                    Message message = Message.obtain();
                    message.what = 1;
                    Bundle bundle = new Bundle();
                    bundle.putString("content", "我是处理后的内容");
                    message.setData(bundle);
                    mHander.sendMessage(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHander.removeCallbacksAndMessages(null); // 防止内存泄漏
    }
}
