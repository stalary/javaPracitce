package com.stalary.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * RemoveDemo
 *
 * @author lirongqian
 * @since 2018/02/15
 */
public class RemoveDemo {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 3, 2, 4, 5));
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            Integer number= it.next();
            if (number % 2 == 0) {
                set.remove(number);
            }
        }
    }
}