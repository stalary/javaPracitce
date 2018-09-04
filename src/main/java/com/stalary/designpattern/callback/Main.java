/**
 * @(#)Main.java, 2018-09-04.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.callback;

import org.springframework.util.StopWatch;

/**
 * Main
 *
 * @author lirongqian
 * @since 2018/09/04
 */
public class Main {

    public static void main(String[] args) {
        Task task = new ZooTask();
        StopWatch sw = new StopWatch();
        sw.start("task");
        task.execute(() -> System.out.println("execute finish"));
        sw.stop();
        System.out.println(sw.prettyPrint());
    }
}