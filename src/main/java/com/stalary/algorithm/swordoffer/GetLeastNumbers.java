/**
 * @(#)GetLeastNumbers.java, 2017-12-20.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

import java.util.ArrayList;

/**
 * GetLeastNumbers
 *
 * 获取最小的k的数
 * @author lirongqian
 * @since 20/12/2017
 */
public class GetLeastNumbers {

    public static void main(String[] args) {
        int[] input = new int[]{
                4, 5, 1, 6, 2, 7, 3, 8
        };
        System.out.println(new GetLeastNumbers().GetLeastNumbers_Solution(input, 4));
    }

    /**
     * 首先找出最小值，存入list的，然后再次进入循环，找出最小值并且要比list的最后一个值(list中的最大值)大
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input.length == 0 || k > input.length || k <= 0) {
            return list;
        }
        int temp = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < input.length; j++) {
                if (input[j] < min && input[j] > temp) {
                    min = input[j];
                }
            }
            temp = min;
            list.add(min);
        }
        return list;
    }
}