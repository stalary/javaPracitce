/**
 * @(#)BlockingQueueDemo.java, 2018-02-04.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.runnable;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;
import java.util.concurrent.*;

/**
 * BlockingQueueDemo
 *
 * @author lirongqian
 * @since 2018/02/04
 */
public class BlockingQueueDemo {

    private static ExecutorService service = Executors.newCachedThreadPool();

    static class Consumer implements Runnable {

        BlockingQueue<String> queue;

        public Consumer(BlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                    if (StringUtils.isNotEmpty(queue.peek())) {
                        System.out.println("接收到：" + queue.poll());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
        Future<?> submit = service.submit(new Consumer(queue));
        System.out.println();
        Scanner in = new Scanner(System.in);
        while (true) {
            String str = in.next();
            queue.offer(str);
            System.out.println("异步");
        }
    }
}