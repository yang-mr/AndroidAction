package com.yw.yw.action.eventbus;

/**
 * Created on 2018/7/2715:30.
 * Author jackyang
 * -------------------------------
 *
 * @description
 * @email 3180518198@qq.com
 */

public class MessageEvent {
    public MessageEvent(String title) {
        this.title = title;
    }

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
