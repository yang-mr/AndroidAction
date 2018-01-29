package com.example.viewanim;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class AnimatorActivity extends AppCompatActivity implements View.OnClickListener {
    private boolean mIsShow = false;
    private ImageButton item1, item2, item3, item4, item5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator);

        findViewById(R.id.menu_bt).setOnClickListener(this);
        item1 = findViewById(R.id.menu_item1);
        item1.setOnClickListener(this);
        item2 = findViewById(R.id.menu_item2);
        item2.setOnClickListener(this);
        item3 = findViewById(R.id.menu_item3);
        item3.setOnClickListener(this);
        item4 = findViewById(R.id.menu_item4);
        item4.setOnClickListener(this);
        item5 = findViewById(R.id.menu_item5);
        item5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menu_bt:
                doAnimatorSet();
                break;
            default:
                Toast.makeText(this, v.getId() + "", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void doAnimatorSet() {
        if (mIsShow) {
            mIsShow = false;
            //隐藏 图标动画
            doAnimatorItemByNoShow(item1, 0);
            doAnimatorItemByNoShow(item2, 1);
            doAnimatorItemByNoShow(item3, 2);
            doAnimatorItemByNoShow(item4, 3);
            doAnimatorItemByNoShow(item5, 4);
        } else {
            mIsShow = true;
            //显示 图标动画
            doAnimatorItemByShow(item1, 0);
            doAnimatorItemByShow(item2, 1);
            doAnimatorItemByShow(item3, 2);
            doAnimatorItemByShow(item4, 3);
            doAnimatorItemByShow(item5, 4);
        }
    }

    private void doAnimatorItemByNoShow(final ImageButton item1, int i) {

        AnimatorSet set = new AnimatorSet();
        double degree = Math.toRadians(90 / 4 * i);
        float translationX = (float) (500 * Math.sin(degree));
        float translationY = (float) (500 * Math.cos(degree));
        ObjectAnimator translationXAnimator = ObjectAnimator.ofFloat(item1, "translationX", -translationX, 50);
        ObjectAnimator translationYAnimator = ObjectAnimator.ofFloat(item1, "translationY", -translationY, 50);
        ObjectAnimator ScaleXAnimator = ObjectAnimator.ofFloat(item1, "scaleX", 1f, 0f);
        ObjectAnimator ScaleYAnimator = ObjectAnimator.ofFloat(item1, "scaleY", 1f, 0f);
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(item1, "alpha", 1f, 0f);

        set.playTogether(translationXAnimator, translationYAnimator, ScaleXAnimator, ScaleYAnimator, alphaAnimator);
        set.setDuration(3000);
        set.start();
        item1.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (item1.getVisibility() == View.VISIBLE) {
                    item1.setVisibility(View.GONE);
                }
            }
        }, 2000);

    }

    private void doAnimatorItemByShow(ImageButton item, int i) {
        if (item.getVisibility() != View.VISIBLE) {
            item.setVisibility(View.VISIBLE);
        }
        AnimatorSet set = new AnimatorSet();
        //double degree = 90 / 4 * i;
        double degree = Math.toRadians(90)/(4) * i;
    // Math.sin(degree)  degree:对应角度的弧度值
        float translationX = (float) (500 * Math.sin(degree));
        float translationY = (float) (500 * Math.cos(degree));
        ObjectAnimator translationXAnimator = ObjectAnimator.ofFloat(item, "translationX", 0, -translationX);
        ObjectAnimator translationYAnimator = ObjectAnimator.ofFloat(item, "translationY", 0, -translationY);
        ObjectAnimator ScaleXAnimator = ObjectAnimator.ofFloat(item, "scaleX", 0f, 1f);
        ObjectAnimator ScaleYAnimator = ObjectAnimator.ofFloat(item, "scaleY", 0f, 1f);
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(item, "alpha", 0f, 1f);

        set.playTogether(translationXAnimator, translationYAnimator, ScaleXAnimator, ScaleYAnimator, alphaAnimator);
        set.setDuration(3000);
        set.start();
    }
}
