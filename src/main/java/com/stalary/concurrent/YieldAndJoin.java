/**
 * @(#)YieldAndJoin.java, 2018-02-05.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.concurrent;

/**
 * YieldAndJoin
 *
 * @author lirongqian
 * @since 2018/02/05
 */
public class YieldAndJoin {

    public static void main(String[] args) throws InterruptedException {
        Thread producer = new Producer();
        Thread consumer = new Consumer();
        producer.setPriority(Thread.MAX_PRIORITY);
        consumer.setPriority(Thread.MIN_PRIORITY);
        producer.start();
//        producer.join();
        consumer.start();
    }
}

class Producer extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("I am Producer : Produced Item " + i);
//            Thread.yield();
        }
    }
}

class Consumer extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("I am Consumer : Consumed Item " + i);
//            Thread.yield();
        }
    }
}
