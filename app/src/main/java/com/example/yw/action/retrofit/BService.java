package com.example.yw.action.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created on 2018/2/622:19.
 * Author jackyang
 * -------------------------------
 *
 * @description
 * @email 3180518198@qq.com
 */

public interface BService {
    @GET("blog/{id}")
    Call<ResponseBody> getBlog(@Path("id") int id);

}
