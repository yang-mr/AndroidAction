package com.example.yw.action.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yw.action.R;
import com.example.yw.action.retrofit.model.Blog;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.annotations.Nullable;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
 *  reference:
 *  1.http://blog.csdn.net/lmj623565791/article/details/51304204
 *  
 * @param
 * @return
 */
public class RetrofitActivity extends AppCompatActivity {
    Retrofit mRetrofit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        initRetrofit();

        testGet();
        testUploadFile();
        testUploadFiles();

        // 配置OkHttpClient addInterceptor
        testAddInterceptor();
    }

    /**
     Desc 配置 OkhttpClient
     18-2-8:上午10:01
     Author jack
    */
    private void testAddInterceptor() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                return null;
            }
        }).build();
    }

    /**
     Desc test upload file
     18-2-8:上午9:41
     Author jack
    */
    private void testUploadFile() {
        BService bService = mRetrofit.create(BService.class);

        File file = new File("");
        RequestBody filePart = RequestBody.create(MediaType.parse("image/png"), file);
        MultipartBody.Part partBody = MultipartBody.Part.createFormData("file", "test.png", filePart);

        bService.uploadFile(partBody, RequestBody.create(null, "122222"));
    }

    /**
     Desc test upload files
     18-2-8:上午9:41
     Author jack
    */
    private void testUploadFiles() {
        BService bService = mRetrofit.create(BService.class);

        File file = new File("");
        RequestBody requestBody = RequestBody.create(MediaType.parse("image/png"), file);
        Map<String, RequestBody> map = new HashMap<>();
        map.put("\"fileByService\\\"; filename=\\\"icon.png\",", requestBody);  // fileByService 同服务器对应
        map.put("name", RequestBody.create(null, "jack")); // set param
        bService.uploadFiles(map, RequestBody.create(null, "122222"));
    }

    private void testGet() {
        BService bService = mRetrofit.create(BService.class);
        Call<Blog> call = bService.getBlog(10);  // call: ExecutorCallAdapterFactory.ExecutorCallbackCall
        call.enqueue(new Callback<Blog>() {
            @Override
            public void onResponse(Call<Blog> call, Response<Blog> response) {
            }

            @Override
            public void onFailure(Call<Blog> call, Throwable throwable) {
            }
        });
    }


    private void initRetrofit() {
        String baseUrl = "";
        mRetrofit = new Retrofit.Builder()
                            .baseUrl(baseUrl)
                            .addConverterFactory(GsonConverterFactory.create())  // converter
                            .addCallAdapterFactory(new CallAdapter.Factory() {   // callAdapter
                                @Nullable
                                @Override
                                public CallAdapter<?, ?> get(Type type, Annotation[] annotations, Retrofit retrofit) {
                                    return null;
                                }
                            })
                            .build();
    }
}
