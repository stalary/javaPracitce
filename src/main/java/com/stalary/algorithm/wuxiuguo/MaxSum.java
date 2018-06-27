/**
 * @(#)MaxSum.java, 2018-06-26.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.algorithm.wuxiuguo;

/**
 * MaxSum
 *
 * @author lirongqian
 * @since 2018/06/26
 */
public class MaxSum {

    public static void main(String[] args) {
        System.out.println(new MaxSum().cal(new int[]{
                -2, 11, -4, 13, -5, -2
        }));
    }

    public int cal(int[] num) {
        int max = 0;
        int temp = 0;
        for (int i = 0; i < num.length; i++) {
            if (temp > 0) {
                temp += num[i];
            } else {
                temp = num[i];
            }
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }
}