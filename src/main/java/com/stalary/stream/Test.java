/**
 * @(#)Test.java, 2018-07-18.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Test
 *
 * @author lirongqian
 * @since 2018/07/18
 */
public class Test {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        IntStream.range(0, 1000).forEach(list::add);
        Collections.shuffle(list);
        long start1 = System.currentTimeMillis();
        List<Integer> collect1 = list.stream().parallel().sorted().collect(Collectors.toList());
        Collections.shuffle(list);
        System.out.println("parallel time." + (System.currentTimeMillis() - start1));
        long start2 = System.currentTimeMillis();
        List<Integer> collect2 = list.stream().sorted().collect(Collectors.toList());
        System.out.println("time." + (System.currentTimeMillis() - start2));

    }
}