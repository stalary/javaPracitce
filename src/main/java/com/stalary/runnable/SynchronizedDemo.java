/**
 * @(#)SynchronizedDemo.java, 2017-11-26.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.runnable;

/**
 * SynchronizedDemo
 *
 * @author lirongqian
 * @since 2017/11/26
 */
public class SynchronizedDemo implements Runnable {

    static int i = 0;

    /**
     * 对静态方法加锁，相当于对类加锁，放入Thread中两个新对象，也是互斥的
     */
    static synchronized void increase() {
        i++;
    }

    /**
     * 对实例方法加锁，相当于对对象加锁，放入Thread中两个对象，不互斥
     */
    synchronized void increaseObj() {
        i++;
    }
//    @Override
//    public void run() {
//        for(int j=0;j<1000000;j++){
//            increase();
//        }
//    }

    /**
     * 代码块加锁，代表对当前实例加锁
     *
     */
    @Override
    public void run() {
        synchronized (this) {
            for (int j = 0; j < 1000000; j++) {
                i++;
            }
        }
    }


    public static void main(String[] args) throws Exception {
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
        Thread t1 = new Thread(synchronizedDemo);
        Thread t2 = new Thread(synchronizedDemo);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}