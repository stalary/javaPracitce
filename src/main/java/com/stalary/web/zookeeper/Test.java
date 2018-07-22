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
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Test
 *
 * @author lirongqian
 * @since 2018/07/21
 */
public class Test {

    public static void lock(InterProcessMutex lock, String path) {
        try {
            // 1s获取不到就失败
            lock.acquire(1, TimeUnit.SECONDS);
            System.out.println(Thread.currentThread().getName() + " zk lock success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void unLock(InterProcessMutex lock, String path) {
        try {
            lock.release();
            // release只删除了子节点，父节点需要手动释放
            client.delete().forPath(path);
            System.out.println(Thread.currentThread().getName() + " zk unLock success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getAllLock() throws Exception {
        System.out.println("allLock" + client.getChildren().forPath(path));
    }

    private static CuratorFramework client;

    private static PathChildrenCache cache;

    private static String path = "/distribute-lock";

    private static ExecutorService executor = Executors.newFixedThreadPool(4);

    public static void main(String[] args) throws Exception {
//        String zkAddr = "ns014x.corp.youdao.com:24500";
        String zkAddr = "server1:2181";
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        client = CuratorFrameworkFactory.builder()
                .connectString(zkAddr)
                .sessionTimeoutMs(2000)
                .connectionTimeoutMs(2000)
                .retryPolicy(retryPolicy)
                .namespace("tr")
                .build();
        client.start();
        cache = new PathChildrenCache(client, path, true);
        cache.start();
        PathChildrenCacheListener listener = (client, event) -> {
            switch (event.getType()) {
                case CHILD_ADDED: {
                    System.out.println("Lock added: " + event.getData().getPath());
                    break;
                }
                case CHILD_UPDATED: {
                    System.out.println("Lock changed: " + event.getData().getPath());
                    break;
                }
                case CHILD_REMOVED: {
                    System.out.println("Lock removed: " + event.getData().getPath());
                    break;
                }
                default:
                    break;
            }
        };
        cache.getListenable().addListener(listener);
        InterProcessMutex lock = new InterProcessMutex(client, path + "/98024:12131:stalary@163.com");
        executor.execute(() -> {
            Thread.currentThread().setName("first");
            lock(lock, path + "/98024:12131:stalary@163.com");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                unLock(lock, path + "/98024:12131:stalary@163.com");
            }
        });

        InterProcessMutex lock1 = new InterProcessMutex(client, path + "/98024:12131:stalary123@163.com");
        executor.execute(() -> {
            Thread.currentThread().setName("second");
            lock(lock1, path + "/98024:12131:stalary123@163.com");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                unLock(lock1, path + "/98024:12131:stalary123@163.com");
            }
        });

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            switch (in.nextInt()) {
                case 1:
                    getAllLock();
                    break;
                case 2:
                    client.delete()
                            .guaranteed()
                            .deletingChildrenIfNeeded()
                            .forPath(path + "/98024:12131:stalary@163.com");
                    break;
                default:
                    break;
            }
        }
    }
}