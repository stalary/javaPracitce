/**
 * @(#)ForkJoinDemo.java, 2018-02-08.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.runnable;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

/**
 * ForkJoinDemo
 *
 * @author lirongqian
 * @since 2018/02/08
 */
public class ForkJoinDemo extends RecursiveTask<Integer> {

    private static final int THRESHOLD = 2;
    private int start;
    private int end;

    public ForkJoinDemo(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                try {
                    // 睡一秒来模拟耗时操作
                    TimeUnit.SECONDS.sleep(1);
                    sum += i;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            int mid = (start + end) / 2;
            ForkJoin.Wait waitLeft = new ForkJoin.Wait(start, mid);
            ForkJoin.Wait waitRight = new ForkJoin.Wait(mid + 1, end);

            waitLeft.fork();
            waitRight.fork();

            int leftResult = waitLeft.join();
            int rightResult = waitRight.join();
            sum = leftResult + rightResult;
        }
        return sum;
    }

    public static void main(String[] args) {
        int start = 1;
        int end = 10;
        long start2 = System.currentTimeMillis();
        int sum = 0;
        for (int i = start; i <= end; i++) {
            try {
                // 睡一秒来模拟耗时操作
                TimeUnit.SECONDS.sleep(1);
                sum += i;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(sum);
        System.out.println("for time: " + (System.currentTimeMillis() - start2));
        long start1 = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        // 生成一个任务
        ForkJoinDemo task = new ForkJoinDemo(start, end);
        // 执行一个任务
        Future<Integer> result = forkJoinPool.submit(task);
        try {
            System.out.println(result.get());
            System.out.println("Fork/Join time: " + (System.currentTimeMillis() - start1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}