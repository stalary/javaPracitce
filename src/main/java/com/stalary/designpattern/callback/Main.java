/**
 * @(#)Main.java, 2018-09-04.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.callback;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Main2
 *
 * @author lirongqian
 * @since 2018/09/04
 */
public class Main {

    public static void main(String[] args) {
        Task task = new ZooTask();
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(() -> task.execute(() -> System.out.println("execute 1 finish")));
        executor.execute(() -> task.execute(() -> System.out.println("execute 2 finish")));
        executor.execute(() -> task.execute(() -> System.out.println("execute 3 finish")));

    }
}