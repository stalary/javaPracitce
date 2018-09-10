/**
 * @(#)Main.java, 2018-09-08.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.facade;

/**
 * Main2
 *
 * @author lirongqian
 * @since 2018/09/08
 */
public class Main {

    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.start();
        System.out.println("use computer doing something...");
        computer.close();
    }
}