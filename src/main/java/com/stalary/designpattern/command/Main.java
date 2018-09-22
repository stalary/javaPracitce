/**
 * @(#)Main.java, 2018-09-20.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.command;

/**
 * Main
 *
 * @author lirongqian
 * @since 2018/09/20
 */
public class Main {

    public static void main(String[] args) {
        Receiver receiver = new Receiver("stalary");
        Command command = new CommandImpl(receiver);
        Invoker invoker = new Invoker(command);
        invoker.action();
    }
}