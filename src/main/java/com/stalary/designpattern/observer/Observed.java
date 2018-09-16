/**
 * @(#)Observed.java, 2018-09-15.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.observer;

/**
 * Observed
 *
 * @author lirongqian
 * @since 2018/09/15
 */
public interface Observed {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver();
}