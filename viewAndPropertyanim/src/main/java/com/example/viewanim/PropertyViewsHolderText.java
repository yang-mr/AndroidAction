package com.example.viewanim;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * Created on 2017/12/1714:12.
 * Author jackyang
 * -------------------------------
 *
 * @description
 * @email 3180518198@qq.com
 */

public class PropertyViewsHolderText extends TextView {

    public PropertyViewsHolderText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void setChar(Character character) {
        setText(String.valueOf(character));
    }
}
