package com.example.yw.action.view.custom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yw.action.R;

/**
 Desc 1.自定义view 三部曲 onMeasure onLayout onDrawble
      2.事件冲突
      3.事件分发机制
      4.other
      5.GestureDetector. VelocityTracker. Scroll. ViewDragHelper
 ref:
        http://blog.csdn.net/guolin_blog/article/details/12921889
        http://blog.csdn.net/lfdfhl/article/details/51671038
 18-3-14:上午10:56
 Author jack
*/
public class CustomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);


    }
}
