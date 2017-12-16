/**
 * @(#)CyclicBarrierDemo.java, 2017-12-14.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.runnable;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.*;

/**
 * CyclicBarrierDemo
 *
 * @author lirongqian
 * @since 2017/12/14
 */
public class CyclicBarrierDemo implements Runnable {

    // 设置线程池数量
    private final int THREAD_COUNT = 5;

    // 创建屏障数量，屏障全部到达后执行当前类的run方法
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(5, this);

    // 创建线程池
    private Executor executor = Executors.newFixedThreadPool(THREAD_COUNT);

    // 保存每个人的成绩
    private ConcurrentHashMap<String, Integer> scores = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        CyclicBarrierDemo c = new CyclicBarrierDemo();
        c.count();
    }

    private void count() {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            Runnable runnable = () -> {
                // 每个学生的随机成绩
                int temp = random.nextInt(100);
                scores.put(Thread.currentThread().getName(), temp);
                System.out.println(temp);
                try {
                    // 进入屏障，等待其他学生计算完毕
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            };
            executor.execute(runnable);
        }
    }

    @Override
    public void run() {
        int result = 0;
        // 求平均值
        for (Map.Entry<String, Integer> out : scores.entrySet()) {
            result += out.getValue();
        }
        System.out.println("avg: " + result / THREAD_COUNT);
    }
}