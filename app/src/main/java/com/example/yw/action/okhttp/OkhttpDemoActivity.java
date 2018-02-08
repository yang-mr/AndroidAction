package com.example.yw.action.okhttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yw.action.R;

import java.io.File;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class OkhttpDemoActivity extends AppCompatActivity {
    OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp_demo);

        testGetOkhttp();

        testPostOkHttp();

        // 基于Http的文件上传
        testUploadFile();
    }

    /**
     Desc file upload
     18-2-8:下午2:35
     Author jack
    */
    private void testUploadFile() {
        File file = new File("");
        RequestBody fileBody = RequestBody.create(MediaType.parse("application/octet-stream"), file);

        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MediaType.parse("fd"))
                .addPart(Headers.of(
                        "Content-Disposition",
                        "form-data; name=\"username\""),
                        RequestBody.create(null, "张鸿洋"))
                .addPart(Headers.of(
                        "Content-Disposition",
                        "form-data; name=\"mFile\"; filename=\"wjd.mp4\""), fileBody)
                .build();
        Request request = new Request.Builder()
                .url("")
                .post(requestBody)
                .build();

        client.newCall(request);
    }

    private void testPostOkHttp() {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), "json");

        // or
      /*  RequestBody formBody = new FormEncodingBuilder()
                .add("platform", "android")
                .add("name", "bug")
                .add("subject", "XXXXXXXXXXXXXXX")
                .build();*/


        Request request = new Request.Builder()
                .url("")
                .post(requestBody)
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }

    private void testGetOkhttp() {
        Request request = new Request.Builder()
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });

        // or get response
        try {
            Response response = call.execute();
            if (response.isSuccessful()) {
                ResponseBody responseBody = response.body();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
