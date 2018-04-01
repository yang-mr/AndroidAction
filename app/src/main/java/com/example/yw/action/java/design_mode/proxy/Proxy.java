package com.example.yw.action.java.design_mode.proxy;

/**
 * Created by jack
 * On 18-3-30:下午1:51
 * Desc:
 */

public class Proxy implements IOrigin {
    private IOrigin origin;

    public Proxy() {
    }

    public void setOrigin(IOrigin origin) {
        this.origin = origin;
    }

    public Proxy(IOrigin origin) {
        this.origin = origin;
    }

    @Override
    public void exe() {
        if (origin == null) {
            // this.origin = new Origin();
            throw new RuntimeException("please set real origin");
        }
        origin.exe();
    }
}
