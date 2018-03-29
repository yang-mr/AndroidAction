package com.example.yw.action.java.design_mode.combine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack
 * On 18-3-29:下午5:09
 * Desc:
 * 引用大话设计模式的片段：“当发现需求中是体现部分与整体层次结构时，
 * 以及你希望用户可以忽略组合对象与单个对象的不同，
 * 统一地使用组合结构中的所有对象时，就应该考虑组合模式了。”
 *
 *  总店 分店
 *
 *  总店下面是分店
 */

public class Main {
    public static void main(String[] args) {
        Market part1 = new PartMarket();
        Market part2 = new PartMarket();
        List<Market> markets = new ArrayList<>();
        markets.add(part1);
        markets.add(part2);

        Market allMarket = new AllMarket(markets);
        allMarket.consume();
    }
}
