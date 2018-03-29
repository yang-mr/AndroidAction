package com.example.yw.action.java.design_mode.combine;

/**
 * Created on 2018/3/2922:29.
 * Author jackyang
 * -------------------------------
 *
 * @description
 * @email 3180518198@qq.com
 */

public class VideoItem extends BaseItem {
    private String name;

    public VideoItem(String name) {
        this.name = name;
    }

    @Override
    public void scan() {
        System.out.println("name " + this.name + "video scan...");
    }
}
