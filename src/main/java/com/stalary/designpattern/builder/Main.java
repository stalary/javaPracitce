/**
 * @(#)Main.java, 2018-09-04.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.builder;

/**
 * Main
 *
 * @author lirongqian
 * @since 2018/09/04
 */
public class Main {

    public static void main(String[] args) {
        Person hawk = new Person.Builder("hawk", "man")
                .withAddress("jinan")
                .withAge(22)
                .build();
        System.out.println(hawk);
        Person claire = new Person.Builder("claire", "woman")
                .withAddress("beijing")
                .withAge(21)
                .build();
        System.out.println(claire);
        Person stalary = new Person.Builder("stalary", "man1")
                .withAddress("beijing")
                .withAge(22)
                .build();
        System.out.println(stalary);
    }
}