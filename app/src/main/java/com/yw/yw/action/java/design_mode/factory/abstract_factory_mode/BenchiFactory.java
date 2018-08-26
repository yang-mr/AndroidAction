package com.yw.yw.action.java.design_mode.factory.abstract_factory_mode;

/**
 * Created by jack
 * On 18-3-27:下午2:06
 * Desc:
 */

public class BenchiFactory extends AbsFactory {
    @Override
    public Engine createEngine() {
        return new BenchiEngine();
    }

    @Override
    public Clutch createClutch() {
        return new BenchiClutch();
    }
}
