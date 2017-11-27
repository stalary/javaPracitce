/**
 * @(#)InterruptDemo.java, 2017-11-26.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.runnable;

import java.util.concurrent.TimeUnit;

/**
 * InterruptDemo
 *
 * @author lirongqian
 * @since 2017/11/26
 */
public class InterruptDemo implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                //当前线程处于阻塞状态，异常必须捕捉处理，无法往外抛出
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            System.out.println("Interruted When Sleep");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                //while在try中，通过异常中断就可以退出run循环
                try {
                    while (true) {
                        //当前线程处于阻塞状态，异常必须捕捉处理，无法往外抛出
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println(this.isInterrupted());
                    }
                } catch (Exception e) {
                    System.out.println("Interruted When Sleep");
                    boolean interrupt = this.isInterrupted();
                    //中断状态被复位
                    System.out.println("interrupt:"+interrupt);
                }
            }
        };
        t1.start();
//        TimeUnit.SECONDS.sleep(2);
        //中断处于阻塞状态的线程
        t1.interrupt();
    }
}