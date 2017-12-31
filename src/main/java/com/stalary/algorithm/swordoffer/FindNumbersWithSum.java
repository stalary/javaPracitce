/**
 * @(#)FindNumbersWithSum.java, 2017-12-31.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * FindNumbersWithSum
 *
 * 给定一个数组和一个数字，在数组中查找两个数字的和相加为目标值，如果多对，则输入乘积最小的一对
 * @author lirongqian
 * @since 31/12/2017
 */
public class FindNumbersWithSum {

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        Set<Integer> set = new HashSet<>();
        for (int out : array) {
            set.add(out);
        }
        ArrayList<Integer> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int a = 0;
        int b = 0;
        for (int i = 0; i < array.length; i++) {
            int temp = sum - array[i];
            if (set.contains(temp)) {
                if (max < temp) {
                    max = temp;
                    a = array[i];
                    b = temp;
                }
            }
        }
        if (a == 0 && b == 0) {
            return list;
        }
        list.add(a);
        list.add(b);
        return list;
    }
}