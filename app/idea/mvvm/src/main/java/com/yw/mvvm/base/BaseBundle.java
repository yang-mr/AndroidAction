package com.yw.mvvm.base;

import android.view.View;

import com.yw.mvvm.manager.DataManager;
import com.yw.mvvm.utils.ConfigureUtils;

import org.greenrobot.eventbus.EventBus;

import me.bakumon.statuslayoutmanager.library.StatusLayoutManager;

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
    private StatusLayoutManager statusLayoutManager;

    public enum ShowLayoutType {
        SHOW_LOADING_LAYOUTU,
        SHOW_EMPTY_LAYOUT,
        SHOW_ERROR_LAYOUT,
        SHOW_SUCCESS_LAYOUT
    }

    public EventBus getEventBus() {
        return eventBus;
    }

    public DataManager getDataManager() {
        return dataManager;
    }

    public void initStatusLayoutManager(View contentLayout) {
        statusLayoutManager = ConfigureUtils.getStatusLayoutManager(contentLayout);
    }

    public void showLayout(ShowLayoutType type) {
        if (statusLayoutManager == null) {
            return;
        }
        switch (type) {
            case SHOW_LOADING_LAYOUTU:
                statusLayoutManager.showLoadingLayout();
                break;
            case SHOW_EMPTY_LAYOUT:
                statusLayoutManager.showEmptyLayout();
                break;
            case SHOW_ERROR_LAYOUT:
                statusLayoutManager.showErrorLayout();
                break;
            case SHOW_SUCCESS_LAYOUT:
                statusLayoutManager.showSuccessLayout();
                break;
            default:
                break;
        }
    }
}
