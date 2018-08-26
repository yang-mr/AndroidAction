package com.yw.yw.action.java.design_mode.singleton;

import android.os.Handler;
import android.os.Message;

import com.yw.yw.action.java.design_mode.singleton.The_class_level_holder_class.ClassLevelSingleton;
import com.yw.yw.action.java.design_mode.singleton.duplication_check.CheckSingleton;
import com.yw.yw.action.java.design_mode.singleton.hungry.HungrySingleton;
import com.yw.yw.action.java.design_mode.singleton.lazy.LazySingleton;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by jack
 * On 18-3-29:上午9:50
 * Desc:
 */

public class Main {
    private static AtomicInteger count = new AtomicInteger(0);
    private final static int threadCount = 100;
    private static long startTime = 0;
    // private static Handler handler = new MyHandler();

    public static void main(String[] args) {

        // test hungry
        // testHungrySingleton();

        // testLazySingleton();

        testCheckSingleton();

        // testClassLevelSingleton();
    }

    private static void testClassLevelSingleton() {
        startTime = System.currentTimeMillis();
        for (int i = 0 ; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    ClassLevelSingleton singleton = ClassLevelSingleton.getInstance();
                    System.out.println("thread_name: " + Thread.currentThread() + " singleton: " + singleton);
                }
            }).start();
        }
    }

    private static void testCheckSingleton() {
        for (int i = 0 ; i < 10000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    CheckSingleton singleton = CheckSingleton.getInstance();
                    System.out.println("thread_name: " + Thread.currentThread() + " singleton: " + singleton);
                }
            }).start();
        }
    }

    private static void testLazySingleton() {
        long startTime = System.currentTimeMillis();
        for (int i = 0 ; i < 10000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    LazySingleton singleton = LazySingleton.getInstance();
                    System.out.println("thread_name: " + Thread.currentThread() + " singleton: " + singleton);
                }
            }).start();
        }
        System.out.println("pay time: " + (System.currentTimeMillis() - startTime));
    }

    private static void testHungrySingleton() {
        for (int i = 0 ; i < 10000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    HungrySingleton singleton = HungrySingleton.getInstance();
                    System.out.println("thread_name: " + Thread.currentThread() + " singleton: " + singleton);
                }
            }).start();
        }
    }

    abstract static class MyThread extends Thread {
        private Handler handler;

        public MyThread(Handler handler) {
            this.handler = handler;
        }

        @Override
        public void run() {
            super.run();
            exe();
            int currentNum = count.decrementAndGet();
            if (currentNum == threadCount - 1) {
                handler.sendEmptyMessage(0);
            }
        }

        abstract void exe();
    }

    static class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    System.out.println("pay time:" + (System.currentTimeMillis() - startTime));
                    break;
            }
        }
    }
}
