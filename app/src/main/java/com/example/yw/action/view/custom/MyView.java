package com.example.yw.action.view.custom;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

import com.orhanobut.logger.Logger;

/**
 * Created by jack
 * On 18-3-19:下午4:24
 * Desc:
 */

public class MyView extends android.support.v7.widget.AppCompatTextView {
    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Logger.d("ACTION_DOWN");
                break;
            case MotionEvent.ACTION_UP:
                Logger.d("ACTION_UP");
                break;
            case MotionEvent.ACTION_MOVE:
                Logger.d("ACTION_MOVE");
                break;
        }

        return super.onTouchEvent(event);
    }
}
