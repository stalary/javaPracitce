/**
 * @(#)SemaphoreDemo.java, 2017-12-14.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.runnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * SemaphoreDemo
 *
 * @author lirongqian
 * @since 2017/12/14
 */
public class SemaphoreDemo {

    // 线程数量
    private static int THREAD_COUNT = 10;

    // 设置线程池大小
    private static final ExecutorService exec = Executors.newFixedThreadPool(THREAD_COUNT);

    // 设置信号量的数量
    private static final Semaphore semaphore = new Semaphore(THREAD_COUNT);

    public static void main(String[] args) {

        for (int i = 0; i < 50; i++) {
            final int No = i;
            Runnable runnable = () -> {
                try {
                    semaphore.acquire();
                    System.out.println("Get: " + No);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                } finally {
                    semaphore.release();
                }
            };
            exec.execute(runnable);
        }
        exec.shutdown();
    }

}