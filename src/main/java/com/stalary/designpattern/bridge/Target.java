/**
 * @(#)Target.java, 2018-09-06.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.bridge;

/**
 * Target
 *
 * @author lirongqian
 * @since 2018/09/06
 */
public class Target implements Bridge {
    @Override
    public void goTarget() {
        System.out.println("我要去目的地");
    }
}