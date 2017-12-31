/**
 * @(#)FindContinuousSequence.java, 2017-12-31.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

import java.util.ArrayList;

/**
 * FindContinuousSequence
 * 给定一个数组和一个数字，求这个数组递增相加可以组成目标数字的list
 * @author lirongqian
 * @since 31/12/2017
 */
public class FindContinuousSequence {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> lists = new FindContinuousSequence().FindContinuousSequence(100);
        for (ArrayList<Integer> list : lists) {
            for (int out : list) {
                System.out.print(out + " ");
            }
            System.out.println();
        }
    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        int small = 1;
        int big = 2;
        while (small <= sum / 2) {
            int result = sum(small, big);
            if (result == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = small; i <= big; i++) {
                    list.add(i);
                }
                lists.add(list);
                small++;
                big++;
            }
            if (result < sum) {
                big++;
            } else {
                small++;
            }
        }
        return lists;
    }

    public int sum(int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    }

}