package com.yw.yw.action.retrofit;

import com.yw.yw.action.retrofit.model.Blog;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;

/**
 * Created on 2018/2/622:19.
 * Author jackyang
 * -------------------------------
 *
 * @description
 * 1.@Path set path
 * 2.@Query set params
 * 3.@Body set request body
 *
 * 4.@FormUrlEncoded(okthttp FormBody) 表单的方式传递简单的键值对
 * 5.@Multipart(okhttp MultipartBody) 单文件上传 表单的方式上传文件可以携带参数
 * 6.@Field
 * 7.@PartMap 多文件上传
 * @email 3180518198@qq.com
 */

public interface BService {
    @GET("blog/{id}")
    Call<Blog> getBlog(@Path("id") int id);

    // file upload

    // 单文件上传@Multipart
    @POST("id")
    @Multipart
    Call<Blog> uploadFile(@Part MultipartBody.Part file, @Part("id") RequestBody id);

    // 多文件上传@PartMap
    @POST("id")
    @Multipart
    Call<Blog> uploadFiles(@PartMap Map<String, RequestBody> params, @Part("id") RequestBody id);
}
