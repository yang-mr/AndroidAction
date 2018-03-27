package com.example.yw.action.java.jvm;

/**
 * Created on 2018/3/1320:46.
 * Author jackyang
 * -------------------------------
 *
 * @description
 * @email 3180518198@qq.com
 */

public class MainParse {
//    static {
//        if (true) {
//            System.out.println(Thread.currentThread() + " exe static code area!");
//            while (true) {

//            }
//        }
//    }
    public static void main(String[] args) {
        // testParse();

        testSlot();
    }

    private static void testSlot() {
        byte[] holder = new byte[64 * 1024 * 1024];
        System.gc();
    }

    // test clinit method 是线程安全的
    private static void testParse() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + " start...");
                MainParse main = new MainParse();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + " start...");
                MainParse main = new MainParse();
            }
        }).start();
    }
}
