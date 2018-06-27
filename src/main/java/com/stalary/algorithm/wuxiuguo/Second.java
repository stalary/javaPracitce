/**
 * @(#)Second.java, 2018-06-19.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.algorithm.wuxiuguo;

import java.util.Arrays;

/**
 * Second
 * 第二大元素
 * @author lirongqian
 * @since 2018/06/19
 */
public class Second {

    public static void main(String[] args) {
        int[] num = new int[]{
                3, 2, 4, 5, 7, 1, 8
        };
        findK(num, 0, num.length - 1, 2);
        System.out.println(Arrays.toString(num));
        System.out.println(num[1]);
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

    public static int findMaxNum(int[] num, int start, int end) {
        int max = 0;
        for (int i = start; i <= end; i++) {
            if (num[i] > max) {
                max = num[i];
            }
        }
        return max;
    }

    /**
     * 划分值大于k-1，向左继续检测
     * 划分值小于k-1，向右继续检测
     * 相等时，代表完成划分
     * @param num
     * @param start
     * @param end
     * @param k
     */
    public static void findK(int[] num, int start, int end, int k) {
        if (start < end) {
            int partitionIndex = partition(num, start, end);
            if (partitionIndex == k - 1) {
                return;
            } else if (partitionIndex > k - 1) {
                findK(num, start, partitionIndex - 1, k);
            } else {
                findK(num, partitionIndex + 1, end, k);
            }
        }
    }

    public static int partition(int[] num, int start, int end) {
        int tempNum = start;
        // 基准值
        int key = num[end];
        for (int j = start; j < end; j++) {
            // 将较大值往前交换
            if (num[j] > key) {
                int temp = num[j];
                num[j] = num[tempNum];
                num[tempNum] = temp;
                // 统计交换到的大值的数量
                tempNum++;
            }
        }
        num[end] = num[tempNum];
        num[tempNum] = key;
        return tempNum;
    }
}