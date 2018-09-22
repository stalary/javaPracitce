/**
 * @(#)ListIterator.java, 2018-09-21.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.iterator;

import java.util.List;

/**
 * ListIterator
 *
 * @author lirongqian
 * @since 2018/09/21
 */
public class ListIterator<T> implements Iterator<T> {

    private List<T> list;

    private int index;

    public ListIterator(List<T> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return index <= list.size();
    }

    @Override
    public T next() {
        T t = list.get(index);
        index++;
        return t;
    }
}