/**
 * @(#)MinimumIndexSumOfTwoLists.java, 2017-12-07.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

import java.util.*;

/**
 * MinimumIndexSumOfTwoLists
 *
 * 求出两个数组中的共同元素，并且他们的下标和要最小，可能会存在多个
 * 思路：使用map存储起来第一组元素和对应的下标，然后第二次循环进行判断是否存在，然后比较下标和
 * @author lirongqian
 * @since 2017/12/7
 */
public class MinimumIndexSumOfTwoLists {

    public static void main(String[] args) {
        String[] list1 = new String[] {
                "Shogun", "Tapioca Express", "Burger King", "KFC"
        };
        String[] list2 = new String[] {
                "Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"
        };
        System.out.println(Arrays.toString(findRestaurant(list1, list2)));
    }

    public static String[] findRestaurant(String[] list1, String[] list2) {
        int len = list1.length + list2.length;
        Map<String, Integer> map = new HashMap<>(len);
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        int min = Integer.MAX_VALUE;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                if (min > map.get(list2[i]) + i) {
                    list.clear();
                    list.add(list2[i]);
                    min = map.get(list2[i]) + i;
                } else if (min == map.get(list2[i]) + i) {
                    list.add(list2[i]);
                }
            } else {
                map.put(list2[i], i);
            }
        }
        return list.toArray(new String[list.size()]);
    }
}