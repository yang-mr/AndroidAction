package com.yw.yw.action.mvvm;

import android.databinding.BindingAdapter;
import android.view.View;

/**
 * Created on 2018/8/2616:48.
 * Author jackyang
 * -------------------------------
 *
 * @description
 * @email 3180518198@qq.com
 */

public class DataBindingUtils {

    @BindingAdapter("visibleOrInvisible")
    public static void setVisibleOrInvisible(View view, boolean isVisible) {
        // view.setVisibility(isVisible == true ? View.VISIBLE, View.INVISIBLE);
    }
}
