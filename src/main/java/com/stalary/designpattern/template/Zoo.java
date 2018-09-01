/**
 * @(#)Zoo.java, 2018-08-31.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.template;

/**
 * Zoo
 *
 * @author lirongqian
 * @since 2018/08/31
 */
public class Zoo {

    private Animal animal;

    public Zoo(Animal animal) {
        this.animal = animal;
    }

    public void see() {
        animal.see();
    }

    public void changeAnimal(Animal animal) {
        this.animal = animal;
    }
}