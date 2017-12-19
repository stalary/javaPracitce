/**
 * @(#)MoreThanHalfNum.java, 2017-12-19.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

import java.util.HashMap;
import java.util.Map;

/**
 * MoreThanHalfNum
 *
 * @author lirongqian
 * @since 19/12/2017
 */
public class MoreThanHalfNum {

    public static void main(String[] args) {
        int[] arr = new int[]{
                1, 2, 3, 2, 2, 2, 5, 4, 2
        };
        System.out.println(new MoreThanHalfNum().MoreThanHalfNum_Solution(arr));
    }

    public int MoreThanHalfNum_Solution(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int out : array) {
            map.put(out, map.getOrDefault(out, 0) + 1);
        }
        for (int out :map.keySet()) {
            if (map.get(out) > array.length / 2) {
                return out;
            }
        }
        return 0;
    }
}