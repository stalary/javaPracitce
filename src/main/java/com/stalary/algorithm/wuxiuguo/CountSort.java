/**
 * @(#)CountSort.java, 2018-06-20.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.algorithm.wuxiuguo;

/**
 * CountSort
 *
 * @author lirongqian
 * @since 2018/06/20
 */
public class CountSort {

    /**
     * 计数排序，申请一定数量的数组，出现就将桶倒出，倒出的顺序即为排序的顺序
     */
    public static int[] countSort(int[] arr, int length) {
        // 先假设最大值和最小值
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < length; i++) {
            // 确定最小值和最大值
            min = Math.min(arr[i], min);
            max = Math.max(arr[i], max);
        }
        //只申请元素差大小的数组，使用时加上起始数值
        int[] countArr = new int[max - min + 1];
        for (int i = 0; i < length; i++) {
            //将出现的元素装入桶中
            countArr[arr[i] - min]++;
        }
        int index = 0;
        for (int i = 0; i < countArr.length; i++) {
            while (countArr[i]-- > 0) {
                //将桶倒出，即为排序后的数组
                arr[index++] = i + min;
            }
        }
        return arr;
    }
}