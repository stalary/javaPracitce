/**
 * @(#)Iphone.java, 2018-09-02.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.factory.abstact;

/**
 * Iphone
 *
 * @author lirongqian
 * @since 2018/09/02
 */
public class Iphone implements IOS {
    @Override
    public void desc() {
        System.out.println("I am iphone ios");
    }
}