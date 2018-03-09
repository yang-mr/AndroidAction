package com.example.yw.action.java.collection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yw.action.R;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CollectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
    }

    public static void main(String[] args) {
      /*  testAdd();

        testGet();

        testRemove();*/

        testAddAll();
    }

    private static void testAddAll() {
        List<String> linkedList = new LinkedList<>();
        linkedList.add("before1");
        List<String> data = new ArrayList<>();
        data.add("test1");
        data.add("test2");
        data.add("test3");
        linkedList.addAll(data);

        linkedList.remove(1);
    }

    private static void testRemove() {
    }

    private static void testGet() {
    }

    private static void testAdd() {
        // test ArrayList
        long startTime = System.currentTimeMillis();
        List<String> dataArrayList = new ArrayList<>();
        for (int i = 0; i < 4000000; i++) {
            // dataArrayList.add("data :" + i);  // arrayList testAdd time:2716 ms
            dataArrayList.add(0, "data: " + i);
        }
        System.out.println("arrayList testAdd time:" + (System.currentTimeMillis() - startTime) + " ms");

        // test LinkedList
        startTime = System.currentTimeMillis();
        List<String> dataLinkedList = new LinkedList<>();
        for (int i = 0; i < 4000000; i++) {
            // dataLinkedList.add("data :" + i); // LinkedList testAdd time:1630 ms
            dataLinkedList.add(0, "data: " + i);
        }
        System.out.println("LinkedList testAdd time:" + (System.currentTimeMillis() - startTime) + " ms");
    }

    private static List<String> getTestData() {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 40000; i++) {
            data.add("data :" + i);
        }
        return data;
    }
}
