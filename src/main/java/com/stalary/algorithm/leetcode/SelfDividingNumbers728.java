/**
 * @(#)SelfDividingNumbers728.java, 2017-11-20.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * SelfDividingNumbers728
 *
 * 求出能被其本身每一个数字整除的数
 * @author lirongqian
 * @since 2017/11/20
 */
public class SelfDividingNumbers728 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int left = 1;
        int right = 22;
        String str;
        for (int i = left; i <= right; i++) {
            Integer temp = i;
            str = temp.toString();
            boolean judge = true;
            for (int j = 0; j < str.length(); j++) {
                int a = Integer.parseInt(String.valueOf(str.charAt(j)));
                if (a == 0) {
                    judge = false;
                    break;
                }
                if (i % a != 0) {
                    judge = false;
                    break;
                }
            }
            if (judge) {
                list.add(i);
            }
        }
        for (int out : list) {
            System.out.print(out + " ");
        }
    }


    /**
     * 第二种解法，求出每一位再进行判断
     */
    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            boolean judge = true;
            if (i % 10 == 0) {
                judge = false;
                continue;
            }
            int temp = i;
            while (temp > 10) {
                if (temp % 10 == 0) {
                    judge = false;
                    break;
                }
                if (i % (temp % 10) != 0) {
                    judge = false;
                    break;
                }
                temp /= 10;
            }
            if (i % temp != 0) {
                judge = false;
                continue;
            }
            if (judge) {
                list.add(i);
            }
        }
        return list;
    }

}