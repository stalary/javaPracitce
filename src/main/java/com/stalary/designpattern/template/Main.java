/**
 * @(#)Main.java, 2018-08-31.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.template;

/**
 * Main
 *
 * @author lirongqian
 * @since 2018/08/31
 */
public class Main {

    public static void main(String[] args) {
        Zoo zoo = new Zoo(new Bird());
        zoo.see();
        zoo.changeAnimal(new Tiger());
        zoo.see();
    }
}