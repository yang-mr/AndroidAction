package com.example.yw.action.rxjava.rxbus;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by jack
 * On 18-2-1:上午9:14
 * Desc:
 */

public class RxBusHelper {
    private static RxBus rxBus;


    public static RxBus getInstance() {
        if (rxBus == null) {
            rxBus = new RxBus();
        }
        return rxBus;
    }
}
