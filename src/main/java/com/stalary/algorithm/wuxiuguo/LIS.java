/**
 * @(#)LIS.java, 2018-06-20.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.algorithm.wuxiuguo;

/**
 * LIS
 * 最长子序列
 * @author lirongqian
 * @since 2018/06/20
 */
public class LIS {

    public static void main(String[] args) {
        System.out.println(new LIS().lisGet(new int[]{
                11, 12, 13, 14, 15, 6, 7, 8, 101, 18
        }));
    }

    public int lisGet(int[] array) {
        // 用于记录当前元素作为最大元素的最长递增序列的长度
        int[] lisLength = new int[array.length];
        // 初始化
        for (int i = 0; i < array.length; i++) {
            lisLength[i] = 1;
        }
        int max = 1;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i] && lisLength[j] + 1 > lisLength[i]) {
                    lisLength[i] = lisLength[j] + 1;
                }
                // 得到当前最长递增序列的长度以及该子序列的最末元素的位置
                if (max < lisLength[i]) {
                    max = lisLength[i];
                }
            }
        }
        return max;
    }
}