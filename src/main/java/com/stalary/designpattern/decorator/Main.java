/**
 * @(#)Main.java, 2018-09-07.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.decorator;

/**
 * Main2
 *
 * @author lirongqian
 * @since 2018/09/07
 */
public class Main {

    public static void main(String[] args) {
        Animal animal = new SheepWolf(new Wolf());
        animal.shout();
        animal.appearance();
    }
}