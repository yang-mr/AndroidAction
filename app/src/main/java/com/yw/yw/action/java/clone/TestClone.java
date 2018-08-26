package com.yw.yw.action.java.clone;

/**
 * Created on 2018/7/2700:28.
 * Author jackyang
 * -------------------------------
 *
 * @description
 * @email 3180518198@qq.com
 */

public class TestClone {

    void fun() {
        System.out.println("fun");
    }

    public static void main(String[] args) throws CloneNotSupportedException {
            TestClone testClone = new TestClone();
            testClone.clone();
    }
}
