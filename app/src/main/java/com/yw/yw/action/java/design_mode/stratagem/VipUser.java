package com.yw.yw.action.java.design_mode.stratagem;

/**
 * Created by jack
 * On 18-4-3:下午3:28
 * Desc:
 */

public class VipUser extends User {
    public VipUser(String name) {
        super(name);
    }

    @Override
    public double realPrice(double allPrice) {
        return allPrice * 0.8;
    }
}
