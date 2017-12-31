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
 * <p>
 * 给定一个数组和一个数字，在数组中查找两个数字的和相加为目标值，如果多对，则输出乘积最小的一对
 *
 * @author lirongqian
 * @since 31/12/2017
 */
public class FindNumbersWithSum {

    /**
     * set存储出现的值，如果存在一个目标值与当前值相减，则与乘积比较判断
     *
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
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

    /**
     * 通过头尾指针来进行判断，可以省去判断是否是最大值
     *
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum1(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (array == null || array.length < 2) {
            return list;
        }
        int i = 0, j = array.length - 1;
        while (i < j) {
            if (array[i] + array[j] == sum) {
                list.add(array[i]);
                list.add(array[j]);
                return list;
            } else if (array[i] + array[j] > sum) {
                j--;
            } else {
                i++;
            }

        }
        return list;
    }

}