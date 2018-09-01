/**
 * @(#)Bird.java, 2018-08-31.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.template;

/**
 * Bird
 *
 * @author lirongqian
 * @since 2018/08/31
 */
public class Bird extends Animal {
    @Override
    protected String introduce() {
        return "bird";
    }

    @Override
    protected void shout() {
        System.out.println("ying ying ying");
    }

    @Override
    protected void doWork() {
        System.out.println("ying ying");
    }
}