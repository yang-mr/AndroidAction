package com.yw.yw.action.java.design_mode.observer.pull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack
 * On 18-3-30:下午5:10
 * Desc:
 */

    public class Observerable {
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
        List<IObserver> observers = new ArrayList<>();

        public boolean addObserver(IObserver observer) {
            return observers.add(observer);
        }

        public boolean removeObserver(IObserver observer) {
            return observers.remove(observer);
        }

        public void change(String msg) {
            for (IObserver iObserver : observers) {
                iObserver.notify(this);
            }
        }
    }
