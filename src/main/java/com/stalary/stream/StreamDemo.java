/**
 * @(#)StreamDemo.java, 2018-01-08.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * StreamDemo
 *
 * @author lirongqian
 * @since 2018/01/08
 */
public class StreamDemo {

    private static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        init();
//        list.stream()
//                .filter(a -> a % 2 != 0)
//                .forEach(a -> System.out.print(a + " "));
//        System.out.println();
//        Optional<Integer> first = list.stream().max(Integer::compareTo);
//        System.out.println(first.get());
       list.stream()
                .distinct()
                .forEach(System.out::print);

    }

    public static void init() {
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(9);
        list.add(1);
    }

}