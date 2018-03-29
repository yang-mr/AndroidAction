package com.example.yw.action.java.design_mode.singleton.lazy;

/**
 * Created by jack
 * On 18-3-29:上午9:41
 * Desc: 时间换空间
 */

public class LazySingleton {
    private static LazySingleton singleton = null;

    // 防止外部实例化
    private LazySingleton(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized LazySingleton getInstance() {
        if (singleton == null) {
            singleton = new LazySingleton();
        }
        return singleton;
    }
}
