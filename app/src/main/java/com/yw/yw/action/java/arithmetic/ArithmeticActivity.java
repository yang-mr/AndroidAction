package com.yw.yw.action.java.arithmetic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yw.yw.action.R;

import java.util.ArrayList;
import java.util.Collection;

public class ArithmeticActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arithmetic);

    }

    public static void main(String[] args) {
        Student[] students = new Student[10];
        // testGeneratic(students);  // test ok

        Collection<Student> students1 = new ArrayList<>();
        testCollection(students1);
    }


    // 范型 PersonViewModel[] Student[]  test ok
    private static void testGeneratic(Person[] persons) {
        for (Person person : persons) {
            System.out.println(person);
        }
    }

    // 范型 PersonViewModel[] Student[]  test ok
    private static void testCollection(Collection<? extends Person> persons) {
        for (Person person : persons) {
            System.out.println(person);
        }
    }

    class Person {

    }

    public class Student extends Person {

    }

    class Employee extends Person {

    }
}
