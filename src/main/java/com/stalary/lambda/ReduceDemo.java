package com.stalary.lambda;

import java.util.stream.Stream;

/**
 * ReduceDemo
 *
 * @author lirongqian
 * @since 2018/02/16
 */
public class ReduceDemo {

    public static void main(String[] args) {

        int max = Stream.of(1, 2, 4, 3)
                .reduce(5, (a, b) -> {
                    System.out.println(a);
                    return a < b ? a : b;
                });
        System.out.println(max);
    }
}