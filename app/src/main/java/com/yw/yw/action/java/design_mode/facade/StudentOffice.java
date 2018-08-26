package com.yw.yw.action.java.design_mode.facade;

/**
 * Created by jack
 * On 18-3-30:上午10:02
 * Desc:
 */

public class StudentOffice implements Organization {
    @Override
    public void operate() {
        System.out.println("my name is 学务处 is operate...");
    }
}
