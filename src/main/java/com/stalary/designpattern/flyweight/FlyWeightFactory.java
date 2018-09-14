/**
 * @(#)FlyWeightFactory.java, 2018-09-13.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * FlyWeightFactory
 *
 * @author lirongqian
 * @since 2018/09/13
 */
public class FlyWeightFactory {

    private Map<String, Person> map = new HashMap<>();

    public Person getPerson(String name) {
        Person person = map.get(name);
        if (person == null) {
            person = new PersonImpl(name);
            map.put(name, person);
        }
        return person;
    }

    public int getCount() {
        return map.size();
    }
}