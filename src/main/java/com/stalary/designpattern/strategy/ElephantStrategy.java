/**
 * @(#)ElephantStrategy.java, 2018-08-30.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.strategy;

/**
 * ElephantStrategy
 *
 * @author lirongqian
 * @since 2018/08/30
 */
public class ElephantStrategy implements ZooStrategy {
    @Override
    public void execute() {
        System.out.println("I am elephant");
    }
}