package com.yw.yw.action.java.design_mode.state;

import java.util.HashMap;

/**
 * Created by jack
 * On 18-4-3:下午2:44
 * Desc:
 */

public class Client {
    private AbsState state;
    public static HashMap<String, Integer> nameMap = new HashMap<>();

    public void vote(String name) {
        Integer count = nameMap.get(name);
        if (count == null) {
            state = new NormalState();
        } else {
            state = new OtherState();
        }
        state.operate(name);
    }
}
