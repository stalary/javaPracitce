/**
 * @(#)Main.java, 2018-09-05.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.adapter;

/**
 * Main
 *
 * @author lirongqian
 * @since 2018/09/05
 */
public class Main {

    public static void main(String[] args) {
        User user = new User(new TwoPinPlugAdapter());
        user.charge();
    }
}