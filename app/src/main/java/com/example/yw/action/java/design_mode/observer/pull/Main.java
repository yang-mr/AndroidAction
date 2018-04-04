package com.example.yw.action.java.design_mode.observer.pull;

/**
 * Created by jack
 * On 18-3-30:下午4:39
 * Desc:
 */

public class Main {
    public static void main(String[] args) {
        // create observerable
        ObserverableImpl observerable = new ObserverableImpl();
        observerable.setName("jack");
        observerable.setAge(100);
        for (int i = 0; i < 5; i++) {
            IObserver observer = new ObserverImpl("jack" + i);
            observerable.addObserver(observer);
        }

        observerable.change("my is change...");
    }
}
