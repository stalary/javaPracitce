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

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;

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

        // 通用对象桶
        /*RBucket<Person> bucket = redisson.getBucket("bucket");
        Person stalary = new Person("stalary", 21);
        bucket.set(stalary);
        System.out.println(bucket.get());
        System.out.println(bucket.trySet(new Person("claire", 20)));
        System.out.println(bucket.compareAndSet(stalary, stalary));
        System.out.println(bucket.getAndSet(new Person("wangwu",20)));*/

        /*// 地理空间对象桶
        RGeo<String> geo = redisson.getGeo("test");
        geo.add(new GeoEntry(13.361389, 38.115556, "Palermo"),
                new GeoEntry(15.087269, 37.502669, "Catania"));
        geo.addAsync(37.618423, 55.751244, "Moscow");
        Double distance = geo.dist("Palermo", "Catania", GeoUnit.METERS);
        System.out.println(distance);
        geo.hashAsync("Palermo", "Catania");
        Map<String, GeoPosition> positions = geo.pos("Palermo", "Catania");
        System.out.println(positions);
        List<String> cities = geo.radius(15, 37, 200, GeoUnit.KILOMETERS);
        Map<String, GeoPosition> citiesWithPositions = geo.radiusWithPosition(15, 37, 200, GeoUnit.KILOMETERS);
        System.out.println(cities);
        System.out.println(citiesWithPositions);

        RBitSet set = redisson.getBitSet("simpleBitset");
        set.set(0, false);
        System.out.println(set.get(0));
        RAtomicLong atomicLong = redisson.getAtomicLong("myAtomicLong");
        atomicLong.set(3);
        System.out.println(atomicLong.get());
        System.out.println(atomicLong.incrementAndGet());
        RHyperLogLog<Integer> log = redisson.getHyperLogLog("log");
        log.add(1);
        log.add(2);
        log.add(3);
        System.out.println(log.count());*/
        RSetMultimap<SimpleKey, SimpleValue> map = redisson.getSetMultimap("myMultimap");
        map.put(new SimpleKey("0"), new SimpleValue("1"));
        map.put(new SimpleKey("0"), new SimpleValue("2"));
        map.put(new SimpleKey("3"), new SimpleValue("4"));

        Set<SimpleValue> allValues = map.get(new SimpleKey("0"));
        System.out.println(allValues);

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