package com.yw.yw.action.rxjava.rxbus;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by jack
 * On 18-2-1:上午9:14
 * Desc:
 */

public class RxBus {
    private PublishSubject bus;

    public RxBus() {
        if (bus == null) {
            bus = PublishSubject.create();
        }
    }

    public Observable toObservable() {
        return bus;
    }

    public void send(Object object) {
        bus.onNext(object);
    }
}
