package com.example.propertyAnim;

import android.animation.TimeInterpolator;

/**
 * Created on 2017/12/1522:55.
 * Author jackyang
 * -------------------------------
 *
 * @description 刚好跟LinearInterpolator 插值器相反
 *
 * Evaluator就是将从加速器返回的数字进度转成对应的数字值。
 * @email 3180518198@qq.com
 */

public class MyInterploator implements TimeInterpolator {
    @Override
    public float getInterpolation(float input) {
        //Evaluator就是将从加速器返回的数字进度转成对应的数字值。 input:加速器返回的数字进度
        return 1 - input;
    }
}
