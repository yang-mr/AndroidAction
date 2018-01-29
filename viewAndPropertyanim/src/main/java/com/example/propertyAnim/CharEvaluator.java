package com.example.propertyAnim;

import android.animation.TypeEvaluator;

/**
 * Created on 2017/12/1523:31.
 * Author jackyang
 * -------------------------------
 *
 * @description
 * @email 3180518198@qq.com
 */

public class CharEvaluator implements TypeEvaluator<Character> {
    @Override
    public Character evaluate(float fraction, Character startValue, Character endValue) {
        int startInt = startValue;
        int endInt = endValue;
        int type =  (int) (startInt + fraction * (endInt - startInt));
        return (char)type;
    }
}
