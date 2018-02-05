package com.example.yw.action.java.reflect;

/**
 * Created by jack
 * On 18-2-5:下午2:17
 * Desc:
 */

public class User implements Person {
    public Integer id;
    public String userName;
    public final static String password = "sss";

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    @Override
    public String toString(){
        return this.getClass().getName();
    }

    public Class getObject() {
        return this.getClass();
    }

    @Override
    public boolean isPerson() {
        return false;
    }

    public static void getName(String id) {

    }
}
