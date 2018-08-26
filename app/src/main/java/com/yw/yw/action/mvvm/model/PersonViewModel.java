package com.yw.yw.action.mvvm.model;

import android.view.View;

/**
 * Created on 2018/8/307:51.
 * Author jackyang
 * -------------------------------
 *
 * @description
 * @email 3180518198@qq.com
 */

public class PersonViewModel {
    private String name;

    public PersonViewModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void onClick(View view) {
        System.out.println(getName());
    }
}
