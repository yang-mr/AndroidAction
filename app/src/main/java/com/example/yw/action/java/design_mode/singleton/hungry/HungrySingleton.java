package com.example.yw.action.java.design_mode.singleton.hungry;

/**
 * Created by jack
 * On 18-3-29:上午9:32
 * Desc: 空间换时间
 */

public class HungrySingleton {
    private static HungrySingleton singleton = new HungrySingleton();

    // 防止外部实例化
    private HungrySingleton() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static HungrySingleton getInstance() {
        return singleton;
    }
}
