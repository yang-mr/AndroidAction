package com.example.yw.action.view.custom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.example.yw.action.R;

import java.util.logging.Logger;

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
    private MyView myView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);

        myView = findViewById(R.id.myview);
        myView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                com.orhanobut.logger.Logger.d("exe onTouch......");
                return false;
            }
        });

        myView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.orhanobut.logger.Logger.d("exe onClick......");
            }
        });
    }
}
