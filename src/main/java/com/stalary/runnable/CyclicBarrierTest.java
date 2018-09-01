/**
 * @(#)CyclicBarrierTest.java, 2018-08-31.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.runnable;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * CyclicBarrierTest
 *
 * @author lirongqian
 * @since 2018/08/31
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(5);
        ExecutorService service = Executors.newFixedThreadPool(5);
        AtomicInteger count = new AtomicInteger(0);
        for (int i = 0; i < 5; i++) {
            Random random = new Random();
            service.execute(() -> {
                count.addAndGet(10 + random.nextInt(100));
                try {
                    System.out.println("cur count: " + count.intValue());
                    cb.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        service.execute(() -> System.out.println("arg: " + count.intValue() / 5));
    }
}