package com.yw.yw.action.java.design_mode.factory.abstract_factory_mode;

/**
 * Created by jack
 * On 18-3-27:下午2:04
 * Desc:
 */

public class BMWFactory extends AbsFactory {
    @Override
    public Engine createEngine() {
        return new BMWEngine();
    }

    @Override
    public Clutch createClutch() {
        return new BMWClutch();
    }
}
