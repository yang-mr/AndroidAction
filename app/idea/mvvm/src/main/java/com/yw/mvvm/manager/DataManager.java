package com.yw.mvvm.manager;

/**
 * Created on 2018/8/2617:02.
 * Author jackyang
 * -------------------------------
 *
 * @description
 * @email 3180518198@qq.com
 */

public class DataManager {
    private RequestManager requestManager = new RequestManager();
    private CacheManager cacheManager;

    public DataManager() {
    }

    public CacheManager getCacheManager() {
        if (cacheManager == null) {
            cacheManager = new CacheManager();
        }
        return cacheManager;
    }

    public RequestManager getRequestManager() {
        return requestManager;
    }
}
