package com.example.yw.action.java.design_mode.adapter.object_adapter;

/**
 * Created by jack
 * On 18-3-29:下午2:15
 * Desc:
 */

public class Main {
    public static void main(String[] args) {
        OriginProduct originProduct = new OriginProduct();

        LastProduct lastProduct = new LastProduct(originProduct);
        lastProduct.originProductWork();
        lastProduct.lastProductWork();
    }
}
