/**
 * @(#)Receiver.java, 2018-09-20.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.command;

/**
 * Receiver
 *
 * @author lirongqian
 * @since 2018/09/20
 */
public class Receiver {
    public String name;
    public Receiver(String name) {
        this.name = name;
    }
    public void action() {
        System.out.println(name + " receive command");
    }
}