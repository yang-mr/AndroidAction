package com.example.yw.action.java.design_mode.stratagem;

/**
 * Created by jack
 * On 18-4-3:下午3:27
 * Desc:
 */

public abstract class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name) {
        this.name = name;
    }

    public abstract double realPrice(double allPrice);
}
