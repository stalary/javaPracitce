/**
 * @(#)Main.java, 2018-08-28.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.delegate;

import com.stalary.designpattern.delegate.print.Elephant;
import com.stalary.designpattern.delegate.print.Monkey;

/**
 * Main2
 *
 * @author lirongqian
 * @since 2018/08/28
 */
public class Main {

    public static void main(String[] args) {
        ZooController elephant = new ZooController(new Elephant());
        ZooController monkey = new ZooController(new Monkey());
        elephant.print("hello world");
        monkey.print("hello world");
    }
}