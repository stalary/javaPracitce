/**
 * @(#)CommandImpl.java, 2018-09-20.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.command;

/**
 * CommandImpl
 *
 * @author lirongqian
 * @since 2018/09/20
 */
public class CommandImpl implements Command {
    private Receiver receiver;
    public CommandImpl(Receiver receiver) {
        this.receiver = receiver;
    }
    @Override
    public void exec() {
        receiver.action();
    }
}