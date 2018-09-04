/**
 * @(#)Task.java, 2018-09-04.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.callback;

/**
 * Task
 *
 * @author lirongqian
 * @since 2018/09/04
 */
public abstract class Task {

    public final void execute(CallBack callBack) {
        execute();
        callBack.call();
    }

    public abstract void execute();
}