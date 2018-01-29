package com.example.viewanim;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.IntEvaluator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import android.widget.Toast;

import com.example.propertyAnim.CharEvaluator;
import com.example.propertyAnim.MyEvaluator;
import com.example.propertyAnim.MyInterploator;

public class MainActivity extends Activity implements View.OnClickListener {
    private TextView mTvTest;

    private MyView mMyView;

    private PropertyViewsHolderText mPropertyView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvTest = findViewById(R.id.tv_test);
        mMyView = findViewById(R.id.myview);
        mPropertyView = findViewById(R.id.propertyViewsHolderText);

        mTvTest.setOnClickListener(this);
        findViewById(R.id.bt).setOnClickListener(this);

        findViewById(R.id.set_bt).setOnClickListener(this);
        findViewById(R.id.bt_Tween).setOnClickListener(this);
    }

    private void testCustomObjectAnimator() {
        ValueAnimator animator = ObjectAnimator.ofInt(mMyView, "pointRadio", 200);
        animator.setDuration(1000);
        animator.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.set_bt:
                startActivity(new Intent(this, AnimatorActivity.class));
                break;
            case R.id.bt_Tween:
                // 补间动画
                testTween();
                break;
            case R.id.bt_ValueAnimator:
                // ValueAnimator 动画
                testValueAnimator();
                break;
            default:

        }

        //testKeyframe();
        //AnimatorSetByXMLSet();
        //if (v == mTvTest) {
//            Toast.makeText(this, "我被点击啦" + " left:" + mTvTest.getLeft(), 1).show();
//            return;
//        }
    }

    private void testTween() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alphaanim);
        findViewById(R.id.tv_test).startAnimation(animation);    //使用xml 生成动画
        //        //代码 使用动画
//        ScaleAnimation scaleAnimation = new ScaleAnimation(1, 1, 2, 2);
//        scaleAnimation.setDuration(1000);
//        scaleAnimation.setFillEnabled(true);
//        scaleAnimation.setInterpolator(new BounceInterpolator());   //设置插值器  比如先加速 后减速等
//
//
//        RotateAnimation rotateAnim = new RotateAnimation(0, 720,
//                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//
//        TranslateAnimation translateAnimation = new TranslateAnimation(10, 300, 10, 400);
//        //使用动画集合
      /*  AnimationSet setAnim = new AnimationSet(true);
        setAnim.addAnimation(rotateAnim);
        setAnim.addAnimation(scaleAnimation);
        setAnim.addAnimation(translateAnimation);

        setAnim.setDuration(3000);
        setAnim.setFillAfter(true);

        mTvTest.startAnimation(setAnim);*/
    }

    private void PropertyValuesHolderByOfObject() {
        Keyframe keyframe1 = Keyframe.ofObject(0f, new Character('A'));
        Keyframe keyframe2 = Keyframe.ofObject(0.1f, new Character('L'));
        Keyframe keyframe3 = Keyframe.ofObject(1f, new Character('Z'));
        PropertyValuesHolder holder = PropertyValuesHolder.ofKeyframe("char", keyframe1, keyframe2, keyframe3);
        // PropertyValuesHolder holder = PropertyValuesHolder.ofObject("char", new CharEvaluator(), new Character('A'), new Character('Z'));
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(mPropertyView, holder);
        animator.setEvaluator(new CharEvaluator());
        animator.setDuration(3000);
        animator.start();
    }

    //
    private void testPropertyViewsHolder() {
        PropertyValuesHolder holder1 = PropertyValuesHolder.ofInt("BackgroundColor", 0xffffffff, 0xffff00ff, 0xffffff00, 0xffffffff);
        PropertyValuesHolder holder2 = PropertyValuesHolder.ofFloat("translationZ", 60f, -60, 0, 60f);

        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(mTvTest, holder1, holder2);
        animator.setDuration(1000);
        animator.start();
    }

    //replace 插值器和Evaluator
    private void testKeyframe() {
        Keyframe keyframe1 = Keyframe.ofFloat(0f, 100);
        Keyframe keyframe2 = Keyframe.ofFloat(500);
        keyframe2.setFraction(0.2f);
        Keyframe keyframe3 = Keyframe.ofFloat(0.9f, 100);

        PropertyValuesHolder holder = PropertyValuesHolder.ofKeyframe("translationX", keyframe1, keyframe2, keyframe3);
        ValueAnimator valueAnimator = ObjectAnimator.ofPropertyValuesHolder(mTvTest, holder);
        valueAnimator.setDuration(1000);
        valueAnimator.start();
    }

    public void testValueAnimator() {
        ValueAnimator animator = ValueAnimator.ofInt(0, 400);
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener;
        animator.addUpdateListener(animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value = (int) animation.getAnimatedValue();
                Log.d("ValueAnimator", "value: " + value);
            }
        });

        //监听动画的 各个动作
        Animator.AnimatorListener listener;
        animator.addListener(listener = new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        //取消监听
        animator.removeListener(listener);
        animator.removeUpdateListener(animatorUpdateListener);

        //取消所有 update监听
        animator.removeAllUpdateListeners();

        animator.setDuration(2000);
        animator.start();
    }

    public void testValueAnimatorByInterpolator() {
        ValueAnimator animator = ValueAnimator.ofInt(0, 400);
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener;
        animator.addUpdateListener(animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value = (int) animation.getAnimatedValue();
                mTvTest.layout(mTvTest.getLeft(), value, mTvTest.getRight(),mTvTest.getHeight() + value);
            }
        });

        animator.setInterpolator(new MyInterploator());
        animator.setEvaluator(new MyEvaluator());
        animator.setDuration(2000);
        animator.start();
    }

    public void testValueAnimatorByArgbEvaluator() {
        ValueAnimator animator = ValueAnimator.ofInt(0xffffffff, 0x22222222);
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener;
        animator.addUpdateListener(animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value = (int) animation.getAnimatedValue();
                mTvTest.setBackgroundColor(value);
            }
        });

        animator.setInterpolator(new MyInterploator());
        animator.setEvaluator(new ArgbEvaluator());
        animator.setDuration(2000);
        animator.start();
    }

    public void testValueAnimatorByOfObject() {
        ValueAnimator animator = ValueAnimator.ofObject(new CharEvaluator(), new Character('A'), new Character('Z'));
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener;
        animator.addUpdateListener(animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                char value = (char) animation.getAnimatedValue();
                mTvTest.setText(value + "");
            }
        });

        animator.setDuration(2000);
        animator.start();
    }

    public void testObjectAnimatorByTranslationX() {
        //translationX translationY translation  平移

        //alphaX alphaY  透明度

        //rotation rotationX rotationY 旋转

        //scaleX scaleY 缩放
        ObjectAnimator animator = ObjectAnimator.ofFloat(mTvTest, "translationZ", 100, 0, 200);

        animator.setDuration(2000);
        animator.start();
    }
    /**
     * AnimatorSet 联合动画
     *
     * playSequentially:依次执行动画
     * playTogether:一起执行动画
     *
     */

    public void AnimatorSetByPlaySequentially() {
        ObjectAnimator translationAnimator = ObjectAnimator.ofFloat(mTvTest, "translationX", 100, 0, 200);
        ObjectAnimator bgAnimator = ObjectAnimator.ofInt(mPropertyView, "BackgroundColor", 0xffff00ff, 0xffffff00, 0xffff00ff);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(translationAnimator, bgAnimator);
        animatorSet.setDuration(2000);
        animatorSet.start();
    }

    public void AnimatorSetByPlay() {
        //with 一起执行   before 后执行  after 先执行
        ObjectAnimator translationAnimator = ObjectAnimator.ofFloat(mTvTest, "translationX", 100, 0, 200);
        ObjectAnimator bgAnimator = ObjectAnimator.ofInt(mPropertyView, "BackgroundColor", 0xffff00ff, 0xffffff00, 0xffff00ff);
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSet.Builder builder = animatorSet.play(translationAnimator);
        builder.after(bgAnimator);
        animatorSet.setDuration(2000);
        animatorSet.start();
    }

    public void AnimatorSetByDuration() {
        //duration animatorSet设置的为准  没有设置 则AnimatorItem里设置的为准  Interpolator加速器类似
        ObjectAnimator translationAnimator = ObjectAnimator.ofFloat(mTvTest, "translationX", 100, 0, 200);
        translationAnimator.setDuration(10000);
        ObjectAnimator bgAnimator = ObjectAnimator.ofInt(mPropertyView, "BackgroundColor", 0xffff00ff, 0xffffff00, 0xffff00ff);
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSet.Builder builder = animatorSet.play(translationAnimator);
        builder.after(bgAnimator);
       // animatorSet.setDuration(2000);
        animatorSet.start();
    }

    public void AnimatorSetBysetStartDelay() {
        //setStartDelay 设置延时   AnimatorSet真正激活延时 = AnimatorSet.startDelay+第一个动画.startDelay
        ObjectAnimator translationAnimator = ObjectAnimator.ofFloat(mTvTest, "translationX", 100, 0, 200);
        translationAnimator.setStartDelay(2000);
        ObjectAnimator bgAnimator = ObjectAnimator.ofInt(mPropertyView, "BackgroundColor", 0xffff00ff, 0xffffff00, 0xffff00ff);
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSet.Builder builder = animatorSet.play(translationAnimator);
        builder.before(bgAnimator);
        animatorSet.setStartDelay(2000);
        animatorSet.setDuration(2000);
        animatorSet.start();
    }

    public void AnimatorSetByXML() {
        //xml 实现属性动画 创建 animator dir
        //  android:startOffset：动画激活延时；对应代码中的startDelay(long delay)函数；
        //  animator:ValueAnimator objectAnimator:ObjectAnimator set:AnimatorSet
        ValueAnimator valueAnimator = (ValueAnimator) AnimatorInflater.loadAnimator(this, R.animator.animatortest);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value = (int) animation.getAnimatedValue();
                mTvTest.layout(mTvTest.getLeft(), value, mTvTest.getRight(),mTvTest.getHeight() + value);
            }
        });
        valueAnimator.start();
    }

    public void AnimatorSetByXMLSet() {
        AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.animatortest);
        animatorSet.setTarget(mTvTest);
        animatorSet.start();
    }
}
