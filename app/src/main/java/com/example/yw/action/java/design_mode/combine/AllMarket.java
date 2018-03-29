package com.example.yw.action.java.design_mode.combine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack
 * On 18-3-29:下午5:12
 * Desc:总店
 */

public class AllMarket implements Market {
    private List<Market> partMarkets = null;

    public AllMarket() {
    }

    public AllMarket(List<Market> partMarkets) {
        this.partMarkets = partMarkets;
    }

    public boolean addMarket(Market market) {
        if (partMarkets == null) {
            partMarkets = new ArrayList<>();
        }
        return partMarkets.add(market);
    }

    @Override
    public void consume() {
        System.out.println("总店 consume.....已经记录");
        if (partMarkets != null) {
            for (Market market : partMarkets) {
                market.consume();
            }
        }
    }
}
