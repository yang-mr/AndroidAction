package com.example.yw.action.java.design_mode.state;

import java.util.HashMap;

/**
 * Created by jack
 * On 18-4-3:下午3:25
 * Desc: 模拟投票系统，当
 */

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        for (int i = 0; i < 4; i++) {
            client.vote("小明");
        }
        System.out.println("投票结果如下：");
        HashMap<String, Integer> map = Client.nameMap;
        for (String key : map.keySet()) {
            System.out.println(key + " and voted = " + map.get(key));
        }
    }
}
