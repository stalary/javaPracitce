package com.stalary.lambda;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * MapDemo
 *
 * @author lirongqian
 * @since 2018/02/16
 */
public class MapDemo {

    public static void main(String[] args) {
        List<Integer> list = Stream.of(Arrays.asList(1, 2), Arrays.asList(3,4))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println(list);

    }
}