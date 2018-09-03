/**
 * @(#)Main.java, 2018-09-02.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.factory.simple;

/**
 * Main
 *
 * @author lirongqian
 * @since 2018/09/02
 */
public class Main {

    public static void main(String[] args) {
        Animal animal1 = AnimalFactory.createAnimal(AnimalFactory.DOG);
        animal1.desc();
        Animal animal2 = AnimalFactory.createAnimal(AnimalFactory.ELEPHANT);
        animal2.desc();
    }
}