/**
 * @(#)FindGreatestSumOfSubArray.java, 2017-12-20.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

/**
 * FindGreatestSumOfSubArray
 *
 * 找出最大的连续子序列
 * @author lirongqian
 * @since 20/12/2017
 */
public class FindGreatestSumOfSubArray {

    public static void main(String[] args) {
        int[] array = new int[]{
                6, -3, -2, 7, -15, 1, 2, 2
        };
        System.out.println(new FindGreatestSumOfSubArray().FindGreatestSumOfSubArray(array));
    }

    /**
     * 设置一个临时的变量记录当前值，当小于0时则更改为数组当前值，和记录的最大值进行比较，若大则更换，当数组当前值为正数时，则加上最大值
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int curSum = 0;
        int greatestSum = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (curSum <= 0) {
                //记录当前最大值
                curSum = array[i];
            } else {
                //当array[i]为正数时，加上之前的最大值并更新最大值。
                curSum += array[i];
            }
            if (curSum > greatestSum) {
                greatestSum = curSum;
            }
        }
        return greatestSum;
    }
}