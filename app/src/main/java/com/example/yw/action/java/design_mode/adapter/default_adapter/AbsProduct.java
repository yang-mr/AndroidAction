package com.example.yw.action.java.design_mode.adapter.default_adapter;

/**
 * Created by jack
 * On 18-3-29:下午2:22
 * Desc: 通过一个抽象类来实现接口，然后这个抽象类把接口里面的方法不处理，或者处理，
 *       后面继承的该抽象类的具体类就可以选择性的实现相应的方法
 */

public abstract class AbsProduct implements Targer {
    @Override
    public void originProductWork() {
        // not handler
    }

    @Override
    public void otherWork() {
        System.out.println("some work...");
    }

    @Override
    public void lastProductWork() {
        // not handler
    }
}

