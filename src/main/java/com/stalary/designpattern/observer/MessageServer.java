/**
 * @(#)MessageServer.java, 2018-09-15.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * MessageServer
 *
 * @author lirongqian
 * @since 2018/09/15
 */
public class MessageServer implements Observed {

    private List<Observer> list = new ArrayList<>();

    private String message;

    @Override
    public void registerObserver(Observer observer) {
        list.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        list.remove(observer);
    }

    @Override
    public void notifyObserver() {
        list.forEach(observer -> observer.update(this.message));
    }

    public void push(String message) {
        this.message = message;
        notifyObserver();
    }
}