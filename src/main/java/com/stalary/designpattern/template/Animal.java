/**
 * @(#)Animal.java, 2018-08-31.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.template;

/**
 * Animal
 *
 * @author lirongqian
 * @since 2018/08/31
 */
public abstract class Animal {

    protected abstract String introduce();

    protected abstract void shout();

    protected abstract void doWork();

    public void see() {
        System.out.println(introduce() + " discover you");
        shout();
        doWork();
    }
}