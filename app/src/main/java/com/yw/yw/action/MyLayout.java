package com.yw.yw.action;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created on 2017/12/3115:39.
 * Author jackyang
 * -------------------------------
 *
 * @description
 * @email 3180518198@qq.com
 */

public class MyLayout extends ViewGroup {
    public MyLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthSpec = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpec = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width = 0;
        int height = 0;

//        measureChildren();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            //measureChild(childView, widthMeasureSpec, heightMeasureSpec);
            MarginLayoutParams layoutParams = (MarginLayoutParams) childView.getLayoutParams();

            //measureChildWithMargins(childView, widthMeasureSpec,0, heightMeasureSpec, 0);
            measureChild(childView, widthMeasureSpec, heightMeasureSpec);
            int childWidth = childView.getMeasuredWidth();
            int childHeight = childView.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;

            width = Math.max(width, childWidth);
            height += childHeight;
        }
        height += getPaddingTop() + getPaddingBottom();    //加上父布局的 padding

        setMeasuredDimension(widthSpec == MeasureSpec.AT_MOST ? width : widthSize,
                heightSpec == MeasureSpec.AT_MOST ? height : heightSize);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int top = getPaddingTop();

        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);

            MarginLayoutParams lp = (MarginLayoutParams) childView.getLayoutParams();

            int childHeight = childView.getMeasuredHeight();

            childView.layout(getPaddingLeft() + lp.leftMargin, top + lp.topMargin,
                    childView.getMeasuredWidth() + getPaddingLeft() + lp.leftMargin,
                    top + childView.getMeasuredHeight() + lp.topMargin);
            top += childHeight + lp.topMargin + lp.bottomMargin;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
