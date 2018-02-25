package com.stalary.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * IteratorDemo
 *
 * @author lirongqian
 * @since 2018/02/15
 */
public class IteratorDemo {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 3, 2, 4, 5));

        for(Iterator<Integer> it = list.iterator(); it.hasNext();) {
            Integer number = it.next();
            if (number % 2 == 0) {
                it.remove();
            }
        }
        System.out.println(list);
        list.add(2);
        list.add(4);
        Iterator iterator = list.iterator();
        iterator.forEachRemaining(o -> System.out.print(o + " "));
    }
}