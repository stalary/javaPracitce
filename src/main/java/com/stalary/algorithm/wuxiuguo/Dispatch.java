/**
 * @(#)Dispatch.java, 2018-06-23.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.algorithm.wuxiuguo;

import java.util.Arrays;

/**
 * Dispatch
 *
 * @author lirongqian
 * @since 2018/06/23
 */
public class Dispatch {

    public static void main(String[] args) {
        System.out.println(new Dispatch().cal(new int[]{
                5, 9, 7, 6
        }));
    }

    /**
     * 前面任务执行时，后面任务需要等待
     * @param arr
     * @return
     */
    public int cal(int[] arr) {
        Arrays.sort(arr);
        // 后面任务依次加上前面任务的执行时间作为等待时间
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i] + arr[i - 1];
        }
        // 将时间求和
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}