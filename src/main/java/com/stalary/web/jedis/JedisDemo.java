
package com.stalary.web.jedis;

import redis.clients.jedis.Jedis;

/**
 * JedisDemo
 *
 * @author lirongqian
 * @since 2017/11/8
 */
public class JedisDemo {

    private static Jedis jedis = new Jedis("127.0.0.1", 6379);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                login(i);
            }
        }
        System.out.println(jedis.bitcount("login"));
    }

    public static void login(long day) {
        jedis.setbit("login", day, true);
    }

}