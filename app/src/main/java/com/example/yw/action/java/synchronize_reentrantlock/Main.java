package com.example.yw.action.java.synchronize_reentrantlock;

import java.util.Random;

/**
 * Created by jack
 * On 18-5-5:上午9:54
 * Desc:
 * ref: https://blog.csdn.net/vking_wang/article/details/9952063
 */
public class Main {
    public static void main(String[] args) {
        testSynchronized();
        
        // testReentrantLock();
    }

    private static void testReentrantLock() {
        final Data data = new Data();
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 5; j++) {
                        data.setData(new Random().nextInt(30));
                    }
                }
            }, "write " + i).start();
        }

        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 5; j++) {
                        data.getData();
                    }
                }
            }, "read " + i).start();
        }
    }

    private static void testSynchronized() {
        final SyncData data = new SyncData();


        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 5; j++) {
                        data.setData(new Random().nextInt(30));
                    }
                }
            }, "write " + i).start();
        }

        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 5; j++) {
                        data.getData();
                    }
                }
            }, "read " + i).start();
        }
    }
}
