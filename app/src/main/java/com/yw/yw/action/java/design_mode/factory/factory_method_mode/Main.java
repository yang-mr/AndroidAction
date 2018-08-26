package com.yw.yw.action.java.design_mode.factory.factory_method_mode;

/**
 * Created by jack
 * On 18-3-27:上午11:57
 * Desc:        工厂方法模式: 如果有个需求奔驰的引擎只能和奔驰的离合器搭配使用, 我们就不能这样提供用户选择;
 *              要改变工厂模式， 把产品搭配好向外提供对应的方法，产品族包括产品结构--这时候就可以使用抽象工厂模式。
 */

public class Main {
    public static void main(String[] args) {
        Car car = new Car(CarPartsFactory.createEngine(CarPartsFactory.ENGINE_BENCHI_TYPE),
                CarPartsFactory.createClutch(CarPartsFactory.CLUTCH_BENCHI_TYPE));
        car.start();
    }
}
