/**
 * @(#)ThreadDemo.java, 2017-12-03.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.runnable;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.Date;

/**
 * ThreadDemo
 *
 * @author lirongqian
 * @since 2017/12/3
 */
public class ThreadDemo implements Runnable {

    static int i = 0;

    void increase() {
        synchronized (ThreadDemo.class) {
            i++;
        }
    }

    public class PrivateClass {

    }

    public static void main(String[] args) throws Exception {
        PrivateClass privateClass = new ThreadDemo().new PrivateClass();
        ThreadDemo instance = new ThreadDemo();
        Thread t1 = new Thread(new ThreadDemo());
        Thread t2 = new Thread(new ThreadDemo());
//        Thread t1 = new Thread(instance);
//        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }

    @Override
    public void run() {
        for (int j = 0; j < 1000000; j++) {
            increase();
        }
    }
}
