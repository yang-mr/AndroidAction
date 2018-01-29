package com.example.yw.action;

import android.graphics.PixelFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 理解Window WindowManager
 */
public class WindowActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_window);

        findViewById(R.id.bt_addwindow).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_addwindow:
                testAddWindow();
                break;
        }
    }

    /**
     * Created from 2018/1/21 17:06
     * Author jackyang
     * ------------------
     * @desc
     * flags
     *  FLAG_NOT_FOCUSABLE: 不需要获取焦点，事件会传递给下层具有焦点的Window
     *  FLAG_NOT_TOUCH_MODAL: 系统会将当前区域以外的单击事件传递给底层的Window，
     *      区域里面的点击事件会自己车里，一般都会开启该Flag，否则不能处理单击事件
     *  FLAG_SHOW_WHEN_LOCKED:  window会显示在锁屏界面
     *
     * type
     *  该参数用来指定Window的类型
     *  应用Window window层级范围1-99
     *      对应着Activity
     *  子Window window层级范围1000-1999
     *      不能单独存在需要依附在父Window，ps dialog
     *  系统Window window层级范围2000-2999
     *      需要声明权限，ps Toast 状态栏
     */
    private void testAddWindow() {
        WindowManager windowManager = getWindowManager();
        /**
         windowManager是WindowManager的实现类WindowManagerImpl
         windowManagerImpl实现了父接口的三个 add update delete view的的方法
         windowManagerImpl通过桥接的设计模式 利用WindowManagerGlobal处理具体的操作view的逻辑
         WindowManagerGlobal.addView() 通过创建ViewRootImpl来增加window进而通过WindowSession, 内部会通过
         WMS类实现Window的添加。即添加过程是一次ipc的调用；
         */
        TextView textView = new TextView(this);
        textView.setBackgroundColor(getColor(R.color.colorAccent));
        textView.setText("test addwindow");
        textView.setOnKeyListener(new View.OnKeyListener() { // fix back
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(keyEvent.getKeyCode() == KeyEvent.KEYCODE_BACK){
                    //捕获返回键
                    WindowActivity.this.finish();
                }
                return true;
            }
        });

        int width = WindowManager.LayoutParams.WRAP_CONTENT;
        int height = WindowManager.LayoutParams.WRAP_CONTENT;
        int flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                /*| WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE*/;
        int type = 0;
        int format = PixelFormat.TRANSPARENT;

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(width, height, flags, type, format);
        layoutParams.x = 100;
        layoutParams.y = 200;
        windowManager.addView(textView, layoutParams);

        /**
         * remove window
         * 对应着WindowManagerGlobal.removeView()
         *
         * removeViewImmediate //也叫同步删除 一般很少用，
         * removeView 也叫异步删除
         * WindowManagerGlobal创建并调用 ViewRootImpl.die实现删除操作
         * die方法里判读是否是异步删除，
         * 异步删除Handler 发送消息，最终handler处理走doDie()
         * 同步删除会立即 走doDie方法
         * doDie方法
         *  会回收一些相关的资源
         *  通过WindowSession(具体实现是Session类)remove Window，最终会调用WMS的removeWindow
         *  让window 不依附父Window
         *  WindowManagerGlobal的doRemoveView 来刷新数据
         *
         * mDyingViews ArrayList保存着即将要删除的Window
         *
         */
        // windowManager.removeView(textView);

        /**
         * update Window
         * viewRootImpl 的setLayoutParams() 通过scheduleTraversals()来对view重新布局
         * 同时viewRootImpl会通过WindowSession(具体实现Session)来更新Window, 最终会WMS relayoutWindow()
         */
        // windowManager.updateViewLayout(textView, layoutParams);

        Toast.makeText(this, "test ", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        switch (event.getKeyCode()) {
            case KeyEvent.KEYCODE_BACK:
                break;
        }
        return super.dispatchKeyEvent(event);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            //捕获返回键
        }
        return super.onKeyDown(keyCode, event);
    }
}
