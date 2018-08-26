package com.yw.yw.action.java.design_mode.observer.push;

/**
 * Created by jack
 * On 18-3-30:下午4:39
 * Desc:
 */

public class Main {
    public static void main(String[] args) {
        // create observerable
        Observerable observerable = new Observerable();
        for (int i = 0; i < 5; i++) {
            IObserver observer = new ObserverImpl("jack" + i);
            observerable.addObserver(observer);
        }

        observerable.change("my is change...");
    }
}
