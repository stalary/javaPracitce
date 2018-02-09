/**
 * @(#)Volatile.java, 2018-02-04.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.runnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Volatile
 *
 * @author lirongqian
 * @since 2018/02/04
 */
public class VolatileDemo {


    private static ExecutorService service = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {
        Count count = new Count();
        new Thread(count).start();
        new Thread(count).start();
    }

    static class Count implements Runnable {

        private static int counts = 0;
        @Override
        public void run() {
            print();
        }

        public synchronized void print() {
            for (int i = 0; i < 10; i++) {
                counts++;
                System.out.println(counts);
            }
        }
    }
}