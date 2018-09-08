/**
 * @(#)SheepWolf.java, 2018-09-07.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.decorator;

/**
 * SheepWolf
 *
 * @author lirongqian
 * @since 2018/09/07
 */
public class SheepWolf implements Animal {

    Animal animal;

    public SheepWolf(Animal animal) {
        this.animal = animal;
    }

    @Override
    public void shout() {
        animal.shout();
    }

    @Override
    public void appearance() {
        animal.appearance();
        System.out.println("I also have sheepskin");
    }
}