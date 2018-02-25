package com.stalary.lambda;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * FilterDemo
 *
 * @author lirongqian
 * @since 2018/02/16
 */
public class FilterDemo {

    public static void main(String[] args) {
        List<String> list = Stream.of("a", "1abc", "abc1")
                .filter("1abc"::equals)
                .collect(Collectors.toList());
        System.out.println(list);
    }
}