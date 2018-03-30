package com.example.yw.action.java.design_mode.facade;

/**
 * Created by jack
 * On 18-3-30:上午9:59
 * Desc:
 */

public class OfficePart implements Organization {
    @Override
    public void operate() {
        System.out.println("my name is office part ... operate");
    }
}
