/**
 * @(#)Test.java, 2018-07-21.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.web.zookeeper;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * Test
 *
 * @author lirongqian
 * @since 2018/07/21
 */
public class Test {

    public static void lock(InterProcessMutex lock) {
        try {
            lock.acquire();
            System.out.println(Thread.currentThread().getName() + "获取锁成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println(lock.getParticipantNodes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void unLock(InterProcessMutex lock) {
        try {
            lock.release();
            System.out.println(Thread.currentThread().getName() + "释放锁成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        String zkAddr = "server1:2181";
        String lockPath = "/distribute-lock/";
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework cf = CuratorFrameworkFactory.builder()
                .connectString(zkAddr)
                .sessionTimeoutMs(2000)
                .retryPolicy(retryPolicy)
                .build();
        cf.start();
        InterProcessMutex lock = new InterProcessMutex(cf, lockPath + "1");
        new Thread("first") {
            @Override
            public void run() {
                lock(lock);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    unLock(lock);
                }
            }
        }.start();
        InterProcessMutex lock1 = new InterProcessMutex(cf, lockPath + "1");
        new Thread("second") {
            @Override
            public void run() {
                lock(lock1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    unLock(lock1);
                }
            }
        }.start();
    }
}