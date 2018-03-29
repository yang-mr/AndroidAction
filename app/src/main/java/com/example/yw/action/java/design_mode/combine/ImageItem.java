package com.example.yw.action.java.design_mode.combine;

/**
 * Created on 2018/3/2922:28.
 * Author jackyang
 * -------------------------------
 *
 * @description
 * @email 3180518198@qq.com
 */

public class ImageItem extends BaseItem {
    private String name;

    public ImageItem(String name) {
        this.name = name;
    }

    @Override
    public void scan() {
        System.out.println("name :" + this.name + " image scan...");
    }
}
