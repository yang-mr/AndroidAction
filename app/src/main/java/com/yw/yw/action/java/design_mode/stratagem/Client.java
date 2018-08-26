package com.yw.yw.action.java.design_mode.stratagem;

/**
 * Created by jack
 * On 18-4-3:下午3:29
 * Desc:
 */

public class Client {
    private User user;

    public Client(User user) {
        this.user = user;
    }

    public void payPrice(double price) {
        System.out.println(user.getName() + " real pay: " + user.realPrice(price));
    }
}
