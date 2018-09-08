/**
 * @(#)Disk.java, 2018-09-08.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.facade;

/**
 * Disk
 *
 * @author lirongqian
 * @since 2018/09/08
 */
public class Disk {
    public void start() {
        System.out.println("Disk start");
    }

    public void close() {
        System.out.println("Disk close");
    }
}