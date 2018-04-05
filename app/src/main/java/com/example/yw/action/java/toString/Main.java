package com.example.yw.action.java.toString;

/**
 * Created on 2018/4/514:54.
 * Author jackyang
 * -------------------------------
 *
 * @description
 * @email 3180518198@qq.com
 */

public class Main {
    public static void main(String[] args) {
        B b = new B();
    }

    static class A {
        private String name;
        public A() {
            this.name = null;
            System.out.println("create a...");
        }

        @Override
        public String toString() {
            System.out.println("my name is toString...");
            return "";
        }
    }

    static class B extends A {
        public B() {
            System.out.println("create b...");
        }
    }
}
