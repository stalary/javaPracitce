/**
 * @(#)Lock.java, 2018-02-14.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.runnable;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.*;

/**
 * Lock
 *
 * @author lirongqian
 * @since 2018/02/14
 */
public class LockDemo {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        Lock lock1 = readWriteLock.readLock();
        Lock lock2 = readWriteLock.writeLock();
        Condition condition = lock.newCondition();
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        condition.signal();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
    }
}