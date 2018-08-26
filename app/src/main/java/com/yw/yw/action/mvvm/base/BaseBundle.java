package com.yw.yw.action.mvvm.base;

import com.yw.yw.action.mvvm.manager.DataManager;

import org.greenrobot.eventbus.EventBus;

/**
 * Created on 2018/8/2617:01.
 * Author jackyang
 * -------------------------------
 *
 * @description
 * @email 3180518198@qq.com
 */

public class BaseBundle {
    private EventBus eventBus = new EventBus();
    private DataManager dataManager = new DataManager();

    public EventBus getEventBus() {
        return eventBus;
    }

    public DataManager getDataManager() {
        return dataManager;
    }
}
