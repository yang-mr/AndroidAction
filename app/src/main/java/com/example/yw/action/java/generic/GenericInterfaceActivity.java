package com.example.yw.action.java.generic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yw.action.R;

public class GenericInterfaceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic_interface);
    }

    public static void main(String[] args) {
        Generator generator = new Generator2<Integer>(99);
        test(generator);
    }

    private static void test(Generator<Number> generator) {
        generator.test(11);
    }


    // 未传入泛型实参时
    public static class Generator2<T> implements Generator<T> {
        private T t;
        public Generator2(T t) {
            this.t = t;
        }

        @Override
        public void test(T t) {
            this.t = t;
            System.out.println("t: " + t.toString());
        }
    }

    // 传入泛型实参时
    public class Generator3 implements Generator<Integer> {
        @Override
        public void test(Integer integer) {

        }
    }

    public interface Generator<T> {
        void test(T t);
    }
}
