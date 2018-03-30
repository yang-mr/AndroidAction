package com.example.yw.action.java.design_mode.observer.push;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack
 * On 18-3-30:下午5:10
 * Desc:
 */

public abstract class Observerable {
    List<IObserver> observers = new ArrayList<>();

    public boolean addObserver(IObserver observer) {
        return observers.add(observer);
    }

    public boolean removeObserver(IObserver observer) {
        return observers.remove(observer);
    }

    public void change(String msg) {
        for (IObserver iObserver : observers) {
            iObserver.notify(msg);
        }
    }
}
