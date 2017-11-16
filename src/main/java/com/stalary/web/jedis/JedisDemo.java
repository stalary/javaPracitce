/**
 * @(#)JedisDemo.java, 2017-11-08.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.web.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ZParams;

import java.util.HashMap;
import java.util.Map;

/**
 * JedisDemo
 *
 * @author lirongqian
 * @since 2017/11/8
 */
public class JedisDemo {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        Map<String, Double> map = new HashMap<>();
        // 添加空对象
        jedis.zadd("user1", map);
        jedis.zadd("user2", map);
        System.out.println(jedis.zcard("user1"));
        System.out.println(jedis.zcard("user2"));
        System.out.println(jedis.zunionstore("user1","user2"));
    }

}