/**
 * @(#)CountDownLatch.java, 2017-12-14.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.runnable;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch
 *
 * @author lirongqian
 * @since 2017/12/14
 */
public class CountDownLatchDemo {

    // 线程数量
    private static int THREAD_COUNT = 10;

    // 初始化，设置计数器大小
    private static CountDownLatch countDownLatch = new CountDownLatch(THREAD_COUNT);

    // 创建线程池，大小与计数器一致，不一致则无法实现一次并发所有请求
    private static ExecutorService ex = Executors.newFixedThreadPool(THREAD_COUNT);

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            Runnable runnable = () -> {
                try {
                    Thread.sleep(1000);
                    System.out.println("Thread: " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                } finally {
                    // 一个线程执行完毕，计数器减1
                    countDownLatch.countDown();
                }
            };
            // 线程池执行线程
            ex.execute(runnable);
        }
        // 关闭线程池
        ex.shutdown();
    }
}