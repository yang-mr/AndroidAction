package com.yw.yw.action.retrofit.converter;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by jack
 * On 18-2-8:上午11:47
 * Desc:
 */

public class ResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    @Override
    public T convert(ResponseBody responseBody) throws IOException {
        responseBody.string();
        return null;
    }
}
