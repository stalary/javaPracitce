/**
 * @(#)ComparableDemo.java, 2018-01-11.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.compare;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

/**
 * ComparableDemo
 *
 * @author lirongqian
 * @since 2018/01/11
 */
public class ComparableDemo {

    public static void main(String[] args) {
        List<People> peopleList = new ArrayList<>();
        peopleList.addAll(Arrays.asList(new People("stalary", 21),new People("claire", 20),new People("hawk", 19)));
        Collections.sort(peopleList, new PeopleComparator().reversed());
        peopleList.add(new People("aolin", 18));
        System.out.println(peopleList);
        Map<String,String> map1 = new Hashtable<>();
//        Map<String, String> map = Collections.synchronizedMap(new TreeMap<>());
//        map.put("a", "stalary");
//        map.put("c", "claire");
//        map.put("b", "hawk");
//        System.out.println(map);
//        peopleList.sort(Comparator.comparing(People::getAge));
//        System.out.println(peopleList);

    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Person implements Comparable<Person> {

    private String name;
    private Integer age;

    @Override
    public int compareTo(Person o) {
        return this.getAge().compareTo(o.getAge());
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class People {

    private String name;
    private Integer age;

}

@Data
@NoArgsConstructor
class PeopleComparator implements Comparator<People> {


    @Override
    public int compare(People o1, People o2) {
        return o1.getAge() - o2.getAge();
    }

}

