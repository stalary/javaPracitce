/**
 * @(#)Monkey.java, 2018-08-28.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.delegate.print;

import com.stalary.designpattern.delegate.Zoo;

/**
 * Monkey
 *
 * @author lirongqian
 * @since 2018/08/28
 */
public class Monkey implements Zoo {
    @Override
    public void print(String message) {
        System.out.println("I am a monkey: " + message);
    }
}