/**
 * @(#)Wolf.java, 2018-09-07.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.decorator;

/**
 * Wolf
 *
 * @author lirongqian
 * @since 2018/09/07
 */
public class Wolf implements Animal {


    @Override
    public void shout() {
        System.out.println("I am a Wolf");
    }

    @Override
    public void appearance() {
        System.out.println("I have gray fur");
    }
}