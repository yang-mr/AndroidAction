package com.yw.mvvm.utils;

import android.view.View;

import me.bakumon.statuslayoutmanager.library.StatusLayoutManager;

/**
 * Created on 2018/8/2618:15.
 * Author jackyang
 * -------------------------------
 *
 * @description
 * @email 3180518198@qq.com
 */

public class ConfigureUtils {
    private static final int DEFAULT_LOADING_LAYOUT_ID = 1;
    private static final int DEFAULT_EMPTY_LAYOUT_ID = 2;
    private static final int DEFAULT_ERROR_LAYOUT_ID = 3;

    public static StatusLayoutManager getStatusLayoutManager(View contentLayout) {
        return new StatusLayoutManager.Builder(contentLayout)
                .setLoadingLayout(DEFAULT_LOADING_LAYOUT_ID)
                .setEmptyLayout(DEFAULT_EMPTY_LAYOUT_ID)
                .setEmptyLayout(DEFAULT_ERROR_LAYOUT_ID)
                .build();
    }
}
