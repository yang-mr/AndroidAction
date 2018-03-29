package com.example.yw.action.java.design_mode.factory.factory_method_mode;

/**
 * Created by jack
 * On 18-3-27:下午2:04
 * Desc:
 */

public class CarPartsFactory {
    public final static int ENGINE_BENCHI_TYPE = 10;
    public final static int ENGINE_BMW_TYPE = 1;
    public final static int CLUTCH_BENCHI_TYPE = 2;
    public final static int CLUTCH_BMW_TYPE = 3;

    public static Engine createEngine(int type) {
        Engine engine = null;
        switch (type) {
            case ENGINE_BENCHI_TYPE:
                engine = new BenchiEngine();
            case ENGINE_BMW_TYPE:
                engine = new BMWEngine();
                break;
        }
        return engine;
    }

    public static Clutch createClutch(int type) {
        Clutch clutch = null;
        switch (type) {
            case CLUTCH_BENCHI_TYPE:
                clutch = new BenchiClutch();
                break;
            case CLUTCH_BMW_TYPE:
                clutch = new BMWClutch();
                break;
        }
        return clutch;
    }
}
