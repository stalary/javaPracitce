/**
 * @(#)demo.java, 2018-01-25.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.web.productrandconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * demo
 *
 * @author lirongqian
 * @since 2018/01/25
 */
public class Demo {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        BlockingQueue<String> bq = new ArrayBlockingQueue<>(10);
        new Thread(new Producer(bq)).start();
        new Thread(new Consumer(bq), "consumer1").start();
        new Thread(new Consumer(bq), "consumer2").start();
    }
}

class Producer implements Runnable {

    private BlockingQueue<String> bq;

    public Producer(BlockingQueue<String> bq) {
        this.bq = bq;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(1000);
                bq.put(String.valueOf(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable {

    private BlockingQueue<String> bq;

    public Consumer(BlockingQueue<String> bq) {
        this.bq = bq;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(Thread.currentThread().getName() + ":" + bq.take());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
