/**
 * @(#)Invoker.java, 2018-09-20.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.command;

/**
 * Invoker
 *
 * @author lirongqian
 * @since 2018/09/20
 */
public class Invoker {
    private Command command;
    public Invoker(Command command) {
        this.command = command;
    }
    public void action() {
        command.exec();
    }
}