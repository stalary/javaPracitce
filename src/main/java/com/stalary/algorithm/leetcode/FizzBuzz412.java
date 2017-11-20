/**
 * @(#)FizzBuzz412.java, 2017-11-21.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * FizzBuzz412
 *
 * @author lirongqian
 * @since 2017/11/21
 */
public class FizzBuzz412 {

    public static void main(String[] args) {
        int n = 15;
        List<String> list = fizzBuzz(n);
        for (String out : list) {
            System.out.println(out);
        }
    }

    public static List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                list.add("Fizz");
            } else if (i % 5 == 0 && i % 3 != 0) {
                list.add("Buzz");
            } else if (i % 3 == 0 && i % 5 == 0) {
                list.add("FizzBuzz");
            } else {
                list.add(Integer.valueOf(i).toString());
            }
        }
        return list;
    }
}