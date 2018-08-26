package com.yw.yw.action.glide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;
import com.yw.yw.action.R;

public class GlideActivity extends AppCompatActivity implements View.OnClickListener {
    private String uri = "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3588772980,2454248748&fm=27&gp=0.jpg";
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);

        imageView = findViewById(R.id.iv_testglideapp);
        findViewById(R.id.bt_appglide).setOnClickListener(this);
        findViewById(R.id.bt_error).setOnClickListener(this);
        findViewById(R.id.bt_requestoptions).setOnClickListener(this);
        findViewById(R.id.bt_thumbnail).setOnClickListener(this);
        findViewById(R.id.bt_target).setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_appglide:
                appGlideModule();
                break;
            case R.id.bt_error:
                // placeholders 
                error();
            case R.id.bt_requestoptions:
                // requestOptions 
                options();
                break;
            case R.id.bt_thumbnail:
                // requestOptions
                thumbnail();
                break;
            case R.id.bt_target:
                // requestOptions
                target();
                break;
        }
    }

    /**
     * .into(Imageview imageview or target)
     */
    private void target() {
        Target target = Glide.with(this)
                .load(uri)
                .into(imageView);

        // second request
        Glide.with(this)
                .load(uri)
                .into(target);  // 之前开始的任何请求都会被取消，它们使用的资源将被释放

        // or .clear(Target target)
        //Glide.with(this).clear(target); // 这将在不需要开始新的加载的情况下释放掉任何相关资源

        // or .clear(View view)
        //Glide.with(this).clear(imageView);
        // because Glide 的 ViewTarget 子类使用了 Android Framework 的
        // getTag() 和 setTag() 方法来存储每个请求的相关信息
    }

    /**
     * 指定一个 RequestBuilder 以与你的主请求并行启动。缩略图 会在主请求加载过程中展示。
     * 如果主请求在缩略图请求之前完成，则缩略图请求中的图像将不会被展示。
     * [thumbnail] API 允许你简单快速地加载图像的低分辨率版本
     * ，并且同时加载图像的无损版本
     */
    private void thumbnail() {
        Glide.with(this)
                .load(uri)
                .thumbnail(Glide.with(this)
                        .load("thumbnail url"))
                .into(imageView);

        Glide.with(this)
                .load(uri)
                .thumbnail(0.3f) // 如果你只是想为你的加载相同的图片，但尺寸为Target 的某个百分比
                .into(imageView);
    }

    /**
     * .apply(RequestOptions options)
     *   对 RequestOptions 类里的方法的静态import，这会让代码看起来更简洁流畅
     *   可以被调用多次，因此 RequestOption 可以被组合使用。
     *   如果 RequestOptions 对象之间存在相互冲突的设置，
     *   那么只有最后一个被应用的 RequestOptions 会生效
     *
     * .transition(withCrossFade())
     *   TransitionOptions
     *      BitmapTransitionOptions
     *      DrawableTransitionOptions
     *
     * RequestBuilder
     *   是Glide中请求的骨架，负责携带请求的url和你的设置项来开始一个新的加载过程
     */
    private void options() {
        //RequestOptions requestOptions = RequestOptions.centerCropTransform();
        Glide.with(this)
              //  .asBitmap() // get Bitmap RequestBuilder default Drawable RequestBuilder
                .load(uri)
                // .apply(centerCropTransform(this))
               // .apply(requestOptions)
               // .transition(withCrossFade())
                .into(imageView);

        // generated api
//        GlideApp.with(this)
//                .load(uri)
//                .centerCrop()  // not requestOptions
//                .into(imageView);
    }

    /**
     * placeholders
     *  placeholder
     *      当请求正在执行时被展示的 Drawable
     *      如果请求失败并且没有设置error Drawable 和 fallback，那么占位符也会继续显示
        error
             在请求永久性失败时展示。error Drawable
             同样也在请求的url/model为 null ，且并没有设置 fallback Drawable 时展示
        fallback
            fallback Drawable 在请求的url/model为 null 时展示
     */
    private void error() {

    }

    /**
     * generated api
     *
     * GlideModule
         *  GlideApp: 与 Glide.with() 不同，诸如 fitCenter() 和
         *  placeholder() 等选项在 Builder 中直接可用，并不需要再传入单独的 RequestOptions 对象。 ​

       GlideExtension
             @GlideExtension 注解用于标识一个扩展 Glide API 的类
             这种类应该有一个私有的、空的构造方法，应为 final 类型，并且仅包含静态方法。
             被注解的类可以含有静态变量，可以引用其他的类或对象。

             GlideOptions
                用 @GlideOption 注解的静态方法用于扩展 RequestOptions
             GlideType
                被 @GlideType 注解的静态方法用于扩展 RequestManager

     */
    private void appGlideModule() {

        /*GlideApp.with(this)   // GlideApp replace Glide
                .asGiftestType() // glideExtension glideType test
                .load(uri)
                .placeholder(R.drawable.dog)
                .fitCenter()
                .miniThumb()   // glideExtension glideOptions test
                .into(imageView);*/
    }
}
