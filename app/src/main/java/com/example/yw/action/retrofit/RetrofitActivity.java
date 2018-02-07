package com.example.yw.action.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yw.action.R;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import retrofit2.CallAdapter;
import retrofit2.Retrofit;

/**
 * Created from 2018/2/6 22:49
 * Author jackyang
 * ------------------
 * @desc
 *
 *  1.converter  gson etc
 *  2.CallAdapter rxjava ...
 *  3.一些注解
 *
 * @param
 * @return
 */
public class RetrofitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        initRetrofit();
    }

    private void initRetrofit() {
        String baseUrl = "";
        Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(baseUrl)


                            .build();
    }
}
