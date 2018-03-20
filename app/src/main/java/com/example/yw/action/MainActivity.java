package com.example.yw.action;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;

import com.example.yw.action.glide.GlideActivity;
import com.example.yw.action.java.arithmetic.ArithmeticActivity;
import com.example.yw.action.java.classloader.ClassLoaderActivity;
import com.example.yw.action.java.collection.CollectionActivity;
import com.example.yw.action.java.dynamicproxy.ProxyActivity;
import com.example.yw.action.java.equals_hashcode.EqualsActivity;
import com.example.yw.action.java.executor_thread.ExecutorActivity;
import com.example.yw.action.java.generic.GenericActivity;
import com.example.yw.action.java.reflect.ReflectActivity;
import com.example.yw.action.okhttp.OkhttpDemoActivity;
import com.example.yw.action.retrofit.RetrofitActivity;
import com.example.yw.action.rxjava.RxJavaActivity;
import com.example.yw.action.view.ConstraintLayout.ConstraintActivity;
import com.example.yw.action.view.CoordinatorLayout.CoordinatorActivity;
import com.example.yw.action.view.custom.CustomActivity;
import com.example.yw.action.view.recyclerview.RecyclerDemoActivity;

public class MainActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.bt_getleft).setOnClickListener(this);
        findViewById(R.id.bt_window).setOnClickListener(this);
        findViewById(R.id.bt_ipc).setOnClickListener(this);
        findViewById(R.id.bt_sharedPreferences).setOnClickListener(this);
        findViewById(R.id.bt_glide).setOnClickListener(this);
        findViewById(R.id.bt_rxjava).setOnClickListener(this);
        findViewById(R.id.bt_retrofit).setOnClickListener(this);
        findViewById(R.id.bt_net_change).setOnClickListener(this);
        findViewById(R.id.bt_recyclerview).setOnClickListener(this);
        findViewById(R.id.bt_动态代理).setOnClickListener(this);
        findViewById(R.id.bt_泛型).setOnClickListener(this);
        findViewById(R.id.bt_reflect).setOnClickListener(this);
        findViewById(R.id.bt_okhttp).setOnClickListener(this);
        findViewById(R.id.bt_classloader).setOnClickListener(this);
        findViewById(R.id.bt_ssl).setOnClickListener(this);
        findViewById(R.id.bt_constraintlayout).setOnClickListener(this);
        findViewById(R.id.bt_coordinatorlayout).setOnClickListener(this);
        findViewById(R.id.bt_arithmetic).setOnClickListener(this);
        findViewById(R.id.bt_多渠道打包).setOnClickListener(this);
        findViewById(R.id.bt_collection).setOnClickListener(this);
        findViewById(R.id.bt_custom).setOnClickListener(this);
        findViewById(R.id.bt_executor).setOnClickListener(this);
        findViewById(R.id.bt_Equals).setOnClickListener(this);
    }

    private void testHandler() {
        Looper.prepareMainLooper();

        Handler handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                switch (msg.what) {
                    case 0:
                        break;
                }
                return false;
            }
        });
        Looper.loop();
        handler.sendEmptyMessage(0);
    }

    private void testHandlerOnThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                Handler handler = new Handler(new Handler.Callback() {
                    @Override
                    public boolean handleMessage(Message msg) {
                        switch (msg.what) {
                            case 0:
                                break;
                        }
                        return false;
                    }
                });
                Looper.loop();
                handler.sendEmptyMessage(0);
            }
        });
    }

    private void testWindow() {
        //getWindowManager().
        Button bt = new Button(this);
        bt.setText("test window");
        getWindowManager().addView(bt, null);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_getleft:
                // view.getLeft() view.getTop() event.getX() event.getRawX() 等
                startActivity(new Intent(this, GetLeftActivity.class));
                break;
            case R.id.bt_window:
                startActivity(new Intent(this, WindowActivity.class));
                break;
            case R.id.bt_ipc:
                startActivity(new Intent(this, IpcActivity.class));
                break;
            case R.id.bt_sharedPreferences:
                startActivity(new Intent(this, SharedPreferencesActivity.class));
                break;
            case R.id.bt_glide:
                startActivity(new Intent(this, GlideActivity.class));
                break;
            case R.id.bt_rxjava:
                startActivity(new Intent(this, RxJavaActivity.class));
                break;
            case R.id.bt_retrofit:
                startActivity(new Intent(this, RetrofitActivity.class));
                break;
            case R.id.bt_okhttp:
                startActivity(new Intent(this, OkhttpDemoActivity.class));
                break;
            case R.id.bt_net_change:
                startActivity(new Intent(this, NetChangeActivity.class));
                break;
            case R.id.bt_recyclerview:
                // recyclerview 间隔等
                startActivity(new Intent(this, RecyclerDemoActivity.class));
                break;
            case R.id.bt_reflect:
                // java 反射
                startActivity(new Intent(this, ReflectActivity.class));
                break;
            case R.id.bt_动态代理:
                startActivity(new Intent(this, ProxyActivity.class));
                break;
            case R.id.bt_泛型:
                startActivity(new Intent(this, GenericActivity.class));
                break;
            case R.id.bt_classloader:
                startActivity(new Intent(this, ClassLoaderActivity.class));
                break;
            case R.id.bt_ssl:
                startActivity(new Intent(this, ClassLoaderActivity.class));
                break;
            case R.id.bt_constraintlayout:
                startActivity(new Intent(this, ConstraintActivity.class));
                break;
            case R.id.bt_coordinatorlayout:
                startActivity(new Intent(this, CoordinatorActivity.class));
                break;
            case R.id.bt_arithmetic:
                startActivity(new Intent(this, ArithmeticActivity.class));
            case R.id.bt_多渠道打包:
                startActivity(new Intent(this, ReleaseActivity.class));
                break;
            case R.id.bt_collection:
                startActivity(new Intent(this, CollectionActivity.class));
                break;
            case R.id.bt_custom:
                startActivity(new Intent(this, CustomActivity.class));
                break;
            case R.id.bt_executor:
                startActivity(new Intent(this, ExecutorActivity.class));
                break;
            case R.id.bt_Equals:
                startActivity(new Intent(this, EqualsActivity.class));
                break;
        }
    }

    /**
     * 1.layer-list标签实现的阴影只能做为background引入使用在Button上
     * 2.TextView, ImageView 使用如下的方法实现阴影效果
     * Paint.setShadowLayer实现阴影效果
     */
}
