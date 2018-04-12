/*
package com.example.yw.action.glide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskLruCacheWrapper;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.module.AppGlideModule;

import java.io.File;

*/
/**
 * Created by jack
 * On 18-1-22:下午2:24
 * Desc:
 *//*


@GlideModule
public class MyAppGlideModule extends AppGlideModule {
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        super.applyOptions(context, builder);

        */
/**
         * memory cache
         *      默认情况下，Glide使用 LruResourceCache ，这是 MemoryCache 接口的一个缺省实现
         *//*

        int memoryCacheSizeBytes = 1024 * 1024 * 20; // 20mb
        builder.setMemoryCache(new LruResourceCache(memoryCacheSizeBytes));


        */
/**
         * Bitmap 池
         *      Glide 使用 LruBitmapPool 作为默认的 BitmapPool
         *//*

        builder.setBitmapPool(new LruBitmapPool(memoryCacheSizeBytes));

        */
/**
         * disk cache
         *      DiskLruCacheWrapper 作为默认的 磁盘缓存
         *//*

        final int diskCacheSizeBytes = 1024 * 1024 * 100; // 100 MB

        builder.setDiskCache(new DiskCache.Factory() {
            @Nullable
            @Override
            public DiskCache build() {
                return DiskLruCacheWrapper.create(null, diskCacheSizeBytes);   // cache filedir and cache size
            }
        });
    }

    */
/**
     * 注册组件
     *
     * @param context
     * @param glide
     * @param registry
     *//*

    @Override
    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
        super.registerComponents(context, glide, registry);

    }

    class MyDiskCache extends DiskLruCacheWrapper {

        */
/**
         * @param directory
         * @param maxSize
         * @deprecated Do not extend this class.
         *//*

        protected MyDiskCache(File directory, long maxSize) {
            super(directory, maxSize);
        }
    }
}
*/
