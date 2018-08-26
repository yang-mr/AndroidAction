package com.yw.yw.action.java.synchronize_reentrantlock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by jack
 * On 18-5-5:上午9:55
 * Desc:
 */
public class Data {
    private int data;// 共享数据
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public int getData() {
        lock.readLock().lock();
        System.out.println(Thread.currentThread().getName() + "准备读取数据");
        try {
            Thread.sleep(200);
        } catch (Exception e) {

        } finally {
            lock.readLock().unlock();
        }
        System.out.println(Thread.currentThread().getName() + "读取" + this.data);
        return data;
    }

    public void setData(int data) {
        lock.writeLock().lock();
        System.out.println(Thread.currentThread().getName() + "准备写入数据");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
        this.data = data;
        System.out.println(Thread.currentThread().getName() + "写入" + this.data);
    }
}
