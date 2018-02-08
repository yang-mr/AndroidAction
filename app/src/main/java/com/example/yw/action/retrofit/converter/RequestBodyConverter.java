package com.example.yw.action.retrofit.converter;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

/**
 * Created by jack
 * On 18-2-8:上午11:50
 * Desc:
 */

public class RequestBodyConverter<T> implements Converter<T, RequestBody> {
    @Override
    public RequestBody convert(T t) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(t);
        return RequestBody.create(MediaType.parse("application/json; charset=UTF-8"), json);
    }
}
