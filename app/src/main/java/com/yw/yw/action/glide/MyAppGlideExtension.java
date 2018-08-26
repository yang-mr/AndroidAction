package com.yw.yw.action.glide;

/*import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.annotation.GlideExtension;
import com.bumptech.glide.annotation.GlideOption;
import com.bumptech.glide.annotation.GlideType;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestOptions;*/


/**
 * Created by jack
 * On 18-1-22:上午11:18
 * Desc:
 *  GlideExtension
     @GlideExtension 注解用于标识一个扩展 Glide API 的类
     这种类应该有一个私有的、空的构造方法，应为 final 类型，并且仅包含静态方法。
     被注解的类可以含有静态变量，可以引用其他的类或对象。

     GlideOptions
     用 @GlideOption 注解的静态方法用于扩展 RequestOptions
     GlideType
     被 @GlideType 注解的静态方法用于扩展 RequestManager
 */

// @GlideExtension
public class MyAppGlideExtension {
   /* private static final int MINI_THUMB_SIZE = 100;

    private static final RequestOptions DECODE_TYPE_GIF = decodeTypeOf(GifDrawable.class).lock();

    private MyAppGlideExtension() {

    }

    @GlideOption
    public static void miniThumb(RequestOptions options) {
        options.fitCenter()
                .override(MINI_THUMB_SIZE);
    }

    @GlideOption
    public static void test(RequestOptions options, int size) {
        options.circleCrop();
    }

    @GlideType(GifDrawable.class)
    public static void asGiftestType(RequestBuilder<GifDrawable> requestBuilder) {
        requestBuilder
                .transition(new DrawableTransitionOptions())
                .apply(DECODE_TYPE_GIF);
    }*/
}
