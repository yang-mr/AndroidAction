package com.yw.yw.action.retrofit.converter;

import com.yw.yw.action.retrofit.model.Blog;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import io.reactivex.annotations.Nullable;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by jack
 * On 18-2-8:上午11:48
 * Desc:
 */

public class ResponseConverterFactory extends Converter.Factory {
    @Nullable
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        if (type == Blog.class) {
            return new ResponseBodyConverter();
        }
        return super.responseBodyConverter(type, annotations, retrofit);
    }
}
