package com.example.yw.action.java.design_mode.state;

/**
 * Created by jack
 * On 18-4-3:下午2:44
 * Desc:
 */

public class Client {
    private AbsState state;

    public void operateState(int type) {
        if (type == 0) {
            state = new NormalState();
        } else if (type == 1) {
            state = new OtherState();
        }
        state.operate();
    }
}
