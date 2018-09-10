/**
 * @(#)Main.java, 2018-08-26.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.proxy;

/**
 * Main2
 *
 * @author lirongqian
 * @since 2018/08/26
 */
public class Main {

    public static void main(String[] args) {
        ZooProxy proxy = new ZooProxy(new ZooImpl());
        proxy.enter(new User(1, "stalary"));
        proxy.enter(new User(2, "hawk"));
        proxy.enter(new User(3, "claire"));
    }
}