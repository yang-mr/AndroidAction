package com.yw.yw.action.rxjava.rxbus;

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
