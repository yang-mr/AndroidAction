package com.example.yw.action.java.design_mode.combine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2018/3/2922:30.
 * Author jackyang
 * -------------------------------
 *
 * @description 文件夹下可以有文件 图片 视频
 * @email 3180518198@qq.com
 */

public class FolderItem extends BaseItem {
    private String name;

    public FolderItem(String name) {
        this.name = name;
    }

    private List<BaseItem> list;

    public boolean addItem(BaseItem item) {
        if (list == null) {
            list = new ArrayList<>();
        }
        return list.add(item);
    }

    @Override
    public void scan() {
        System.out.println("start scan " + this.name + " file");

        if (list != null) {
            for (BaseItem item : list) {
                item.scan();
            }
        }
    }
}
