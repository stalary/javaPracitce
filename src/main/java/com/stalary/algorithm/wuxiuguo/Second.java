/**
 * @(#)Second.java, 2018-06-19.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.algorithm.wuxiuguo;

/**
 * Second
 * 第二大元素
 * @author lirongqian
 * @since 2018/06/19
 */
public class Second {

    public static void main(String[] args) {
        int[] num = new int[]{
                1, 3, 2, 4, 5, 7
        };
        System.out.println(findSecondNum(num, 0, num.length - 1));
    }

    public static int findSecondNum(int num[], int start, int end) {
        // 注意这个条件，不然会死循环
        if (end - start > 0) {
            int mid = (start + end) / 2;
            int before = findMaxNum(num, start, mid);
            int latter = findMaxNum(num, mid + 1, end);
            // 当前一部分的最大值大时，需要查找一下前一部分的第二大的数
            if (before > latter) {
                int temp = findSecondNum(num, start, mid);
                // 如果大于后一部分最大值，则直接输出
                if (temp > latter) {
                    return temp;
                } else {
                    return latter;
                }
            } else {
                int temp = findSecondNum(num, mid + 1, end);
                if (temp > before) {
                    return temp;
                } else {
                    return before;
                }
            }
        }
        return 0;
    }
    public static int findMaxNum(int num[], int start, int end) {
        int max = 0;
        for (int i = start; i <= end; i++) {
            if (num[i] > max) {
                max = num[i];
            }
        }
        return max;
    }
}