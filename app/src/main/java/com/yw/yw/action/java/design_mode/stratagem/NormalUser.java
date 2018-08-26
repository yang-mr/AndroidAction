package com.yw.yw.action.java.design_mode.stratagem;

/**
 * Created by jack
 * On 18-4-3:下午3:28
 * Desc:
 */

public class NormalUser extends User {
    public NormalUser(String name) {
        super(name);
    }

    @Override
    public double realPrice(double allPrice) {
        return allPrice;
    }
}
