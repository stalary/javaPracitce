/**
 * @(#)Computer.java, 2018-09-08.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.facade;

/**
 * Computer
 *
 * @author lirongqian
 * @since 2018/09/08
 */
public class Computer {

    private CPU cpu;

    private Disk disk;

    private Screen screen;

    public Computer() {
        this.cpu = new CPU();
        this.disk = new Disk();
        this.screen = new Screen();
    }

    public void start() {
        System.out.println("Computer start begin");
        cpu.start();
        disk.start();
        screen.start();
        System.out.println("Computer start finish");
    }

    public void close() {
        System.out.println("Computer close begin");
        cpu.close();
        disk.close();
        screen.close();
        System.out.println("Computer close finish");
    }
}