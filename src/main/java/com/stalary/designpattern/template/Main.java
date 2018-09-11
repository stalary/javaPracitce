/**
 * @(#)Main.java, 2018-08-31.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.template;

/**
 * Main2
 *
 * @author lirongqian
 * @since 2018/08/31
 */
public class Main {

    public static void main(String[] args) {
        Note code = new Code();
        code.send("stalary");
        System.out.println("----------------");
        Note warn = new Warn();
        warn.send("stalary");
    }
}