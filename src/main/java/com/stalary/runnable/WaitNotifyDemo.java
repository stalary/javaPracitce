/**
 * @(#)WaitNotifyDemo.java, 2017-12-11.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.runnable;

/**
 * WaitNotifyDemo
 *
 * @author lirongqian
 * @since 2017/12/11
 */
public class WaitNotifyDemo {

    public void testWait(Object lock) throws InterruptedException {
        synchronized (lock) {
            System.out.println("go to wait " + "thread num: " + Thread.currentThread().getId());
            lock.wait();
//            Thread.sleep(1000);
            System.out.println("left wait " + "thread num: " + Thread.currentThread().getId());
        }
    }

    public void testNotify(Object lock) throws InterruptedException {
        synchronized (lock) {
            System.out.println("go to notify " + "thread num: " + Thread.currentThread().getId());
            lock.notifyAll();
//            Thread.sleep(1000);
            System.out.println("left notify " + "thread num: " + Thread.currentThread().getId());
        }
    }

    static class Thread1 extends Thread {

        private Object lock;

        public Thread1(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                WaitNotifyDemo waitNotifyDemo = new WaitNotifyDemo();
                waitNotifyDemo.testWait(lock);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Thread3 extends Thread {

        private Object lock;

        public Thread3(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                WaitNotifyDemo waitNotifyDemo = new WaitNotifyDemo();
                waitNotifyDemo.testWait(lock);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Thread2 extends Thread {

        private Object lock;

        public Thread2(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                WaitNotifyDemo waitNotifyDemo = new WaitNotifyDemo();
                waitNotifyDemo.testWait(lock);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Thread4 extends Thread {

        private Object lock;

        public Thread4(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                WaitNotifyDemo waitNotifyDemo = new WaitNotifyDemo();
                waitNotifyDemo.testNotify(lock);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static ThreadLocalExt t1 = new ThreadLocalExt();

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws InterruptedException {

//        Object object = new Object();
//        Thread1 thread1 = new Thread1(object);
//        thread1.start();
//        Thread2 thread2 = new Thread2(object);
//        thread2.start();
//        Thread3 thread3 = new Thread3(object);
//        thread3.start();
//        Thread.sleep(1000);
//        Thread4 thread4 = new Thread4(object);
//        thread4.start();


        if (t1.get() == null) {
            System.out.println("从未放过值");
            t1.set("我的值");
        }
        System.out.println(t1.get());
        System.out.println(t1.get());


    }

}

class ThreadLocalExt extends ThreadLocal {
    @Override
    protected Object initialValue() {
        return "我是默认值";
    }
}