package com.yw.mvvm.base;

import org.greenrobot.eventbus.EventBus;

/**
 * Created on 2018/8/2617:01.
 * Author jackyang
 * -------------------------------
 *
 * @description
 * @email 3180518198@qq.com
 */

public class BaseViewModel {
    private EventBus eventBus;

    public BaseViewModel() {
    }

    public BaseViewModel(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void setEventBus(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public EventBus getEventBus() {
        return eventBus;
    }
}
