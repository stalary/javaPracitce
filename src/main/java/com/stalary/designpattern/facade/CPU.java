/**
 * @(#)CPU.java, 2018-09-08.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.facade;

/**
 * CPU
 *
 * @author lirongqian
 * @since 2018/09/08
 */
public class CPU {
    public void start() {
        System.out.println("CPU start");
    }

    public void close() {
        System.out.println("CPU close");
    }
}