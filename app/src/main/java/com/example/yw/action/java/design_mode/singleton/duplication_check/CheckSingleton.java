package com.example.yw.action.java.design_mode.singleton.duplication_check;

/**
 * Created by jack
 * On 18-3-29:上午9:45
 * Desc: 双重检查加锁 对于懒汉单例模式更有效率
 */

public class CheckSingleton {
    private static CheckSingleton singleton;
    private CheckSingleton() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static CheckSingleton getInstance() {
        if (singleton == null) {
            synchronized (CheckSingleton.class) {
                if (singleton == null) {
                    singleton = new CheckSingleton();
                }
            }
        }
        return singleton;
    }
}
