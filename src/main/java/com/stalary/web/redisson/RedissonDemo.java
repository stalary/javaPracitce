/**
 * @(#)RedissonDemo.java, 2017-11-07.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.web.redisson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.config.Config;

import java.util.*;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * RedissonDemo
 *
 * @author lirongqian
 * @since 2017/11/7
 */
@Slf4j
public class RedissonDemo {

    public static void main(String[] args) {
        // 单Redis节点模式 redisson配置

        // 默认连接地址：127.0.0.1:6379
        RedissonClient redisson = Redisson.create();

        /*RSortedSet<Integer> set = redisson.getSortedSet("anySet");
        set.trySetComparator(new MyComparator()); // 配置元素比较器
        set.add(3);
        set.add(1);
        set.add(2);
        set.addAsync(5);
        System.out.println(set);*/

    }

    @Data
    @AllArgsConstructor
    public static class MyComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 < o2) {
                return -1;
            } else if (o1 > o2) {
                return 1;
            }
            return 0;
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Person {

        String name;
        int age;
    }

    @AllArgsConstructor
    @Data
    public static class SimpleKey {

        String key;
    }

    @AllArgsConstructor
    @Data
    public static class SimpleValue {

        String value;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SomeObject {

        String arg;
    }
}