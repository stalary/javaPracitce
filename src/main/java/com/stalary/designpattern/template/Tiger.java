/**
 * @(#)Tiger.java, 2018-08-31.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.template;

/**
 * Tiger
 *
 * @author lirongqian
 * @since 2018/08/31
 */
public class Tiger extends Animal {
    @Override
    protected String introduce() {
        return "tiger";
    }

    @Override
    protected void shout() {
        System.out.println("I will eat you");
    }

    @Override
    protected void doWork() {
        System.out.println("I want to sleep");
    }
}