package com.example.yw.action.java.design_mode.factory.abstract_factory_mode;

/**
 * Created by jack
 * On 18-3-27:上午11:58
 * Desc:
 */

public class Car {
    private Engine engine;
    private Clutch clutch;
    private AbsFactory factory;

    public Car(AbsFactory factory) {
        this.factory = factory;
    }

    public void start() {
        if (factory != null) {
            this.engine = factory.createEngine();
            this.clutch = factory.createClutch();
        }
        engine.start();
        clutch.press();
    }
}
