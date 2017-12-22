/**
 * @(#)PrintMinNumber.java, 2017-12-22.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.swordoffer;

import java.util.ArrayList;

/**
 * PrintMinNumber
 * <p>
 * 给定一个数组，拼成一个字符串数字最小的数
 *
 * @author lirongqian
 * @since 22/12/2017
 */
public class PrintMinNumber {

    public static void main(String[] args) {
        System.out.println(new PrintMinNumber().PrintMinNumber(new int[]{
                3, 32, 321
        }));
    }

    public String PrintMinNumber(int[] numbers) {
        int n;
        StringBuilder s = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();
        n = numbers.length;
        for (int i = 0; i < n; i++) {
            list.add(numbers[i]);

        }
        list.sort((str1, str2) -> {
            String s1 = str1 + "" + str2;
            String s2 = str2 + "" + str1;
            return s1.compareTo(s2);
        });
        for (int j : list) {
            s.append(j);
        }
        return s.toString();
    }

}