/**
 * @(#)ThreadDemo.java, 2017-12-03.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.runnable;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ThreadDemo
 *
 * @author lirongqian
 * @since 2017/12/3
 */
public class ThreadDemo extends Thread {

    static int i = 0;

    private MyService myService;

    public static void main(String[] args) throws Exception {
        MyService service = new MyService();
        ThreadDemo i1 = new ThreadDemo(new MyService());
        ThreadDemo i2 = new ThreadDemo(new MyService());
//        Thread t1 = new Thread(instance);
//        Thread t2 = new Thread(instance);
        i1.start();
        i2.start();
    }

    public ThreadDemo(MyService myService) {
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.testMethod();
    }
}

class MyService {

    private Lock lock = new ReentrantLock();

    public void testMethod() {
        lock.lock();
        for (int i = 0; i < 10; i++) {
            System.out.println("ThreadName = " + Thread.currentThread().getName() + " " + "i = " + i);
        }
        lock.unlock();
    }
}
