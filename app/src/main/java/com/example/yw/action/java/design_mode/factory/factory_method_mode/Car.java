package com.example.yw.action.java.design_mode.factory.factory_method_mode;

/**
 * Created by jack
 * On 18-3-27:上午11:58
 * Desc:
 */

public class Car {
    private Engine engine;
    private Clutch clutch;
    private CarPartsFactory factory;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public Car(Engine engine, Clutch clutch) {
        this.engine = engine;
        this.clutch = clutch;
    }

    public void start() {
        engine.start();
        clutch.press();
    }
}
