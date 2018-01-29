package com.example.propertyAnim;

import android.animation.TypeEvaluator;

/**
 * Created on 2017/12/1523:13.
 * Author jackyang
 * -------------------------------
 *
 * @description
 * @email 3180518198@qq.com
 */

public class MyEvaluator implements TypeEvaluator<Integer> {
    @Override
    public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
        //return 200 + startValue + (int)(fraction * (endValue - startValue)); //原来的基础上加200
        return (int)(endValue - (fraction * (endValue - startValue)));   //倒叙
    }
}
