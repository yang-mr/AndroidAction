package com.yw.yw.action.java.design_mode.singleton.The_class_level_holder_class;

/**
 * Created by jack
 * On 18-3-29:上午9:48
 * Desc:
 *    类级的内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例
 *    没有绑定关系，而且只有被调用到时才会装载，从而实现了延迟加载。
 */

public class ClassLevelSingleton {
    private ClassLevelSingleton(){}

    private static class SingletonHolder {
         /*
          *  * 静态初始化器，由JVM来保证线程安全
         */
        private static ClassLevelSingleton instance = new ClassLevelSingleton();
    }

    public static ClassLevelSingleton getInstance() {
        return SingletonHolder.instance;
    }
}
