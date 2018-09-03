/**
 * @(#)AnimalFactory.java, 2018-09-02.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.factory.simple;

/**
 * AnimalFactory
 *
 * @author lirongqian
 * @since 2018/09/02
 */
public class AnimalFactory {

    public static final int DOG = 1;

    public static final int ELEPHANT = 2;

    public static final int MONKEY = 3;

    public static Animal createAnimal(int type) {
        switch (type) {
            case DOG:
                return new Dog();
            case ELEPHANT:
                return new Elephant();
            case MONKEY:
            default:
                return new Monkey();
        }
    }
}