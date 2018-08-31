/**
 * @(#)MonkeyStrategy.java, 2018-08-30.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.strategy;

/**
 * MonkeyStrategy
 *
 * @author lirongqian
 * @since 2018/08/30
 */
public class MonkeyStrategy implements ZooStrategy {
    @Override
    public void execute() {
        System.out.println("I am monkey");
    }
}