
package com.stalary.web.jedis;

import redis.clients.jedis.Jedis;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * JedisDemo
 *
 * @author lirongqian
 * @since 2017/11/8
 */
public class JedisDemo {

    static AtomicInteger num = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Jedis jedis = new Jedis();
        jedis.set("num","0");
        Demo demo1 = new Demo();
        Demo demo2 = new Demo();
        demo1.start();
//        demo1.join();
        demo2.start();
    }

    static class Demo extends Thread {

        @Override
        public void run() {
            Jedis jedis1 = new Jedis();
            for (int i = 0; i < 10000; i++) {
                num.incrementAndGet();
                jedis1.set("num", num.toString());
                System.out.println(jedis1.get("num"));
            }
        }

    }
}