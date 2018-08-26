package com.yw.yw.action;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class GetLeftActivity extends AppCompatActivity {
    private TextView mTv;
    private final static String TAG = "GetLeftActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_left);

        mTv = (TextView) findViewById(R.id.tv_getleft);

        getLeftgetWidth();

        testgetRawX();
    }

    /**
     * Created from 2018/1/20 23:02
     * Author jackyang
     * ------------------
     * @desc
    event.getX():表示的是触摸的点距离自身左边界的距离
    event.getY():表示的是触摸的点距离自身上边界的距离
    event.getRawX:表示的是触摸点距离屏幕左边界的距离
    event.getRawY:表示的是触摸点距离屏幕上边界的距离
     * @param
     */
    private void testgetRawX() {
        mTv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d(TAG, "getX: " + event.getX());
                Log.d(TAG, "getY: " + event.getY());
                Log.d(TAG, "getRawX: " + event.getRawX());
                Log.d(TAG, "getRawY: " + event.getRawY());
                return false;
            }
        });
    }

    /**
     * Created from 2018/1/20 22:55
     * Author jackyang
     * ------------------
     * @desc getLeft 的值表示当前控件的最左边跟父控件最左边的距离
            getRight 的值表示当前控件的最右边跟父控件最左边的距离 也等于getLeft + getWidth
            getTop 的值表示当前控件的最上边跟父控件最上边的距离
            getBottom 的值表示当前控件的最下边跟父控件最上边的距离 也等于getTop + getHeight
     * @param
     * @return
     */
    private void getLeftgetWidth() {
        mTv.post(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "width: " + mTv.getWidth());
                Log.d(TAG, "height: " + mTv.getHeight());

                Log.d(TAG, "getLeft: " + mTv.getLeft());
                Log.d(TAG, "getTop: " + mTv.getTop());
                Log.d(TAG, "getBottom: " + mTv.getBottom());
                Log.d(TAG, "getRight: " + mTv.getRight());

                Log.d(TAG, "getStatusHeight: " + getStatusHeight());
            }
        });
    }

    /**
     * 获得状态栏的高度
     * @return
     */
    public int getStatusHeight()
    {
        int statusBarHeight1 = -1;
//获取status_bar_height资源的ID
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            //根据资源ID获取响应的尺寸值
            statusBarHeight1 = getResources().getDimensionPixelSize(resourceId);
        }
        return statusBarHeight1;
    }
}
