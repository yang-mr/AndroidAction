package com.example.yw.action.java.design_mode.stratagem;

/**
 * Created by jack
 * On 18-4-3:下午3:29
 * Desc:
 */

public class Main {
    public static void main(String[] args) {
        User user = new VipUser("vipuser1");
        Client client = new Client(user);
        client.payPrice(10000);
    }
}
