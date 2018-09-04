/**
 * @(#)ZooTask.java, 2018-09-04.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.callback;

/**
 * ZooTask
 *
 * @author lirongqian
 * @since 2018/09/04
 */
public class ZooTask extends Task {
    @Override
    public void execute() {
        System.out.println("execute zoo task start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}