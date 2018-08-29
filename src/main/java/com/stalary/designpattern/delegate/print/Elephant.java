/**
 * @(#)Elephant.java, 2018-08-28.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.delegate.print;

import com.stalary.designpattern.delegate.Zoo;

/**
 * Elephant
 *
 * @author lirongqian
 * @since 2018/08/28
 */
public class Elephant implements Zoo {
    @Override
    public void print(String message) {
        System.out.println("I am a elephant: " + message);
    }
}