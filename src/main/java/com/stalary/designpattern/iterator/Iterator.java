/**
 * @(#)Iterator.java, 2018-09-21.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.iterator;

/**
 * Iterator
 *
 * @author lirongqian
 * @since 2018/09/21
 */
public interface Iterator<T> {

    boolean hasNext();

    T next();
}