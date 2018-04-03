package com.example.yw.action.java.design_mode.state;

/**
 * Created by jack
 * On 18-4-3:下午2:46
 * Desc:
 */

public class NormalState extends AbsState {
    @Override
    public void operate() {
        System.out.println("my name is normal state!");
    }
}
