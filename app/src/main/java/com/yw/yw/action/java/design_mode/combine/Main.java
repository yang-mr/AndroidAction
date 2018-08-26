package com.yw.yw.action.java.design_mode.combine;

/**
 * Created on 2018/3/2922:36.
 * Author jackyang
 * -------------------------------
 *
 * @description
 * @email 3180518198@qq.com
 */

public class Main {
    public static void main(String[] args) {
        FolderItem folderItem1 = new FolderItem("文件夹1");
        folderItem1.addItem(new ImageItem("image1"));
        folderItem1.addItem(new ImageItem("image2"));

        FolderItem folderItem2 = new FolderItem("文件夹2");
        folderItem2.addItem(new VideoItem("video1"));
        folderItem2.addItem(new VideoItem("video2"));
        folderItem2.addItem(folderItem1);
        folderItem2.scan();
    }
}
