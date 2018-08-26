package com.yw.yw.action.java.synchronize_reentrantlock;

/**
 * Created by jack
 * On 18-5-5:上午9:55
 * Desc:
 */
public class SyncData {
    private int data;// 共享数据

    public synchronized int getData() {
        System.out.println(Thread.currentThread().getName() + "准备读取数据");
        try {
            Thread.sleep(200);
        } catch (Exception e) {

        }
        System.out.println(Thread.currentThread().getName() + "读取" + this.data);
        return data;
    }

    public synchronized void setData(int data) {
        System.out.println(Thread.currentThread().getName() + "准备写入数据");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.data = data;
        System.out.println(Thread.currentThread().getName() + "写入" + this.data);
    }
}
