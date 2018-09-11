/**
 * @(#)Main.java, 2018-09-09.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Main
 *
 * @author lirongqian
 * @since 2018/09/09
 */
public class Main {

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 4; i++) {
            int finalI = i;
            executor.execute(() -> {
                Thread.currentThread().setName("测试：" + finalI);
                System.out.println("执行：" + finalI);
                try {
                    Thread.sleep(1000 * finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("执行完毕：" + finalI);
            });
        }
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executor;
    }

}