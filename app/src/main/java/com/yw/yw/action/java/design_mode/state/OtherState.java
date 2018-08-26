package com.yw.yw.action.java.design_mode.state;

/**
 * Created by jack
 * On 18-4-3:下午3:23
 * Desc:
 */

public class OtherState extends AbsState {
    @Override
    public void operate(String name) {
        System.out.println("my name is otherState！非正常投票");
    }
}
