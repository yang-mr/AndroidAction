package com.example.yw.action.java.dynamicproxy;

import retrofit2.http.GET;

/**
 * Created by jack
 * On 18-2-7:上午8:59
 * Desc:
 */

public interface IProxyTest {

    @GET("test")
    void login(String username, String password);
}
