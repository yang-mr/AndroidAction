package com.example.yw.action.okhttp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.yw.action.R;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 *   1、noCache()
     对应于“no-cache”，如果出现在 响应 的头部，不是表示不允许对响应进行缓存，而是表示客户端需要与服务器进行再次验证，
        进行一个额外的GET请求得到最新的响应；如果出现请求头部，则表示不适用缓存响应，即记性网络请求获取响应。

     2、noStore()
     对应于"no-store"，如果出现在响应头部，则表明该响应不能被缓存

     ref：
     https://www.jianshu.com/p/b32d13655be7
 */

public class OkhttpDemoActivity extends AppCompatActivity implements View.OnClickListener {
    OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp_demo);

        findViewById(R.id.okio).setOnClickListener(this);


        testPostOkHttp();

        // 基于Http的文件上传
        // testUploadFile();

        // 缓存处理 可以针对每个request指定缓存策略 也可以使用拦截器处理缓存
        // 可以针对每个request指定缓存策略
        // testCacheByRequest();

        // 可以使用拦截器处理缓存
        // testCacheByIn();
    }

    private void testCacheByIn() {
        //缓存文件夹
        File cacheFile = new File(getExternalCacheDir().toString(),"cache");
        //缓存大小为10M
        int cacheSize = 10 * 1024 * 1024;
        //创建缓存对象
        final Cache cache = new Cache(cacheFile,cacheSize);

        client = new OkHttpClient.Builder()
                .cache(cache) // 后台有返回对应的缓存头 不然就使用拦截器模拟后台数据
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Response response = chain.proceed(chain.request());

                        return response.newBuilder().removeHeader("pragma") // pragma也是控制缓存的一个消息头属性
                                .header("Cache-Control", "max-age=60").build(); // cache 60s
                    }
                })
                .build();
    }

    private void testCacheByRequest() {
        CacheControl cacheControl = new CacheControl.Builder()
                .maxAge(60, TimeUnit.SECONDS)
                .build();
        
        Request request = new Request.Builder()
                .url("")
                .cacheControl(cacheControl)
                .build();

        client.newCall(request);
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

        Call call = client.newCall(request);
        try {
            call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

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
                .url("http://www.baidu.com")
                .post(requestBody)
                .build();

        /*Call call = client.newCall(request);
        try {
            call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        client.newCall(request).enqueue(new Callback() {
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
                .url("www.baidu.com")
                .method("GET", null)
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.okio:  // 记录一些io
                startActivity(new Intent(this, OkIoDemoActivity.class));
            break;
        }
    }
}
