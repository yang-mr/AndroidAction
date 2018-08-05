package com.example.yw.action.databinding;

import android.view.View;
import android.widget.Toast;

/**
 * Created on 2018/8/307:51.
 * Author jackyang
 * -------------------------------
 *
 * @description
 * @email 3180518198@qq.com
 */

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void onClick(View view) {
        System.out.println(getName());
    }
}
