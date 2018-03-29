package com.example.yw.action.java.design_mode.adapter.object_adapter;

/**
 * Created by jack
 * On 18-3-29:下午2:13
 * Desc:
 */

public final class LastProduct implements Targer {
    private OriginProduct originProduct;

    public LastProduct(OriginProduct originProduct) {
        this.originProduct = originProduct;
    }

    @Override
    public void originProductWork() {
        if (originProduct != null) {
            originProduct.work();
        }
    }

    @Override
    public void lastProductWork() {
        System.out.println("我是最新的产品，我支持2头啦");
    }
}
