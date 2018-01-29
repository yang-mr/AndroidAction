package com.example.viewanim;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created on 2017/12/1623:44.
 * Author jackyang
 * -------------------------------
 *
 * @description
 * @email 3180518198@qq.com
 */

public class MyView extends View {
    private Point mPoint = new Point(100);

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        canvas.drawCircle(100, 100, mPoint.getmRadio(), paint);
    }

    public void setPointRadio(int radio) {
        mPoint.setmRadio(radio);
        invalidate();
    }

    //如果只给动画设置一个值时，会调用该方法得到 初始值  没有定义该方法  会用默认值 int ：0
    public int getPointRadio() {
        return 50;
    }
}
