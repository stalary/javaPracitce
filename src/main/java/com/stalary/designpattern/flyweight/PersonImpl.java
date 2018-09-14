/**
 * @(#)PersonImpl.java, 2018-09-13.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.flyweight;

/**
 * PersonImpl
 *
 * @author lirongqian
 * @since 2018/09/13
 */
public class PersonImpl implements Person {

    private String name;

    public PersonImpl(String name) {
        this.name = name;
    }

    @Override
    public void introduce(String info) {
        System.out.println("inner parameter:" + this.name);
        System.out.println("outer parameter:" + info);
    }
}