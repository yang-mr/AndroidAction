package com.yw.yw.action.java.design_mode.adapter.class_adapter;

/**
 * Created by jack
 * On 18-3-29:下午2:13
 * Desc:
 */

public class LastProduct extends OriginProduct implements Targer {
    @Override
    public void originProductWork() {
        work();
    }

    @Override
    public void lastProductWork() {
        System.out.println("我是最新的产品，我支持2头啦");
    }
}
