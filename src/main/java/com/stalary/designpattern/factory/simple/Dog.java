/**
 * @(#)Dog.java, 2018-09-02.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.factory.simple;

/**
 * Dog
 *
 * @author lirongqian
 * @since 2018/09/02
 */
public class Dog extends Animal {
    @Override
    public void desc() {
        System.out.println("I am dog");
    }
}