package com.yw.yw.action.java.design_mode.proxy;

/**
 * Created by jack
 * On 18-3-30:下午1:56
 * Desc:
 */

public class Main {
    public static void main(String[] args) {
        Proxy proxy = new Proxy(new Origin());
        proxy.exe();
    }
}
