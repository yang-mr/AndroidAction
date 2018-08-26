package com.yw.yw.action.java.design_mode.facade;

/**
 * Created by jack
 * On 18-3-30:上午10:02
 * Desc:
 */

public class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public void signUp() {
        System.out.println("my name is " + this.name + " and sign up!");
        StudentUnion studentUnion = new StudentUnion();
        studentUnion.operate();
    }
}
