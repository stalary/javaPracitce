/**
 * @(#)Main.java, 2018-09-01.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.prototype;

import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Main
 *
 * @author lirongqian
 * @since 2018/09/01
 */
public class Main {

    public static void main(String[] args) {
        Express express = new Express("stalary", "beijing");
        Map<Integer, List<String>> data = new HashMap<>();
        data.put(1, Lists.newArrayList("hawk", "jinan"));
        data.put(2, Lists.newArrayList("claire", "beijing"));
        data.put(3, Lists.newArrayList("none", "none"));
        for (int i = 1; i <= 3; i ++) {
            express.clone();
            express.setGoods("good:" + i);
            express.setReceiver(data.get(i).get(0));
            express.setReceiveAddress(data.get(i).get(1));
            System.out.println(express);
        }
    }
}