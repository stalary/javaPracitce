/**
 * @(#)Person.java, 2018-09-21.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.iterator;

/**
 * Person
 *
 * @author lirongqian
 * @since 2018/09/21
 */
public class Person {

    public Iterator<Person> iterator() {
        return new ListIterator<>(this);
    }
}