package com.yw.yw.action.mvvm.model;

import com.yw.yw.action.mvvm.base.BaseBundle;

/**
 * Created on 2018/8/2617:13.
 * Author jackyang
 * -------------------------------
 *
 * @description
 * @email 3180518198@qq.com
 */

public class MainBundle extends BaseBundle {
    private MainViewModel mainViewModel;

    public MainBundle() {
        mainViewModel = new MainViewModel(getEventBus());
    }
}
