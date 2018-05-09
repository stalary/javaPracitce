/**
 * @(#)Meituan2.java, 2018-03-22.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.interview;

/**
 * Meituan2
 *
 * @author lirongqian
 * @since 2018/03/22
 */

import java.util.Scanner;

public class Meituan2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        int[] num = new int[10];

        for (char c : s.toCharArray()) {

            num[c - '0']++;

        }

        System.out.println(helper(num));

    }

    public static String helper(int[] num) {
        String[] res = new String[2];
        res[0] = "";
        res[1] = "1";
        int index = 1;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < 10; i++) {
            if (num[i] < min) {
                min = num[i];
                index = i;
            }
        }
        for (int i = 0; i < min + 1; i++) {
            res[0] = res[0] + index;
        }
        for (int i = 0; i < num[0] + 1; i++) {
            res[1] = res[1] + "0";
        }
        if (res[0].length() < res[1].length()) {
            return res[0];
        } else if (res[1].length() < res[0].length()) {
            return res[1];
        } else {
            for (int i = 0; i < res[0].length(); i++) {
                if (res[0].charAt(i) < res[1].charAt(i)) {
                    return res[0];
                } else if (res[1].charAt(i) < res[0].charAt(i)) {
                    return res[1];
                }
            }
        }
        return res[1];
    }
}

