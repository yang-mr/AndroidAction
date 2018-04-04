package com.example.yw.action.java.design_mode.observer.pull;

/**
 * Created by jack
 * On 18-4-4:下午12:01
 * Desc:
 */

public class ObserverableImpl extends Observerable {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
