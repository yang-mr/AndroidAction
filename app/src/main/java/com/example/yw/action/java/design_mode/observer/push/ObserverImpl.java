package com.example.yw.action.java.design_mode.observer.push;

/**
 * Created by jack
 * On 18-3-30:下午5:15
 * Desc:
 */

public class ObserverImpl implements IObserver {
    private String name;

    public ObserverImpl(String name) {
        this.name = name;
    }

    @Override
    public void notify(String msg) {
        System.out.println("name:" + this.name + " my receive msg la!");
    }
}
