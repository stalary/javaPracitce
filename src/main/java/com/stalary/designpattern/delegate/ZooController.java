/**
 * @(#)ZooController.java, 2018-08-28.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.delegate;

/**
 * ZooController
 *
 * @author lirongqian
 * @since 2018/08/28
 */
public class ZooController implements Zoo {

    private final Zoo zoo;

    public ZooController(Zoo zoo) {
        this.zoo = zoo;
    }


    @Override
    public void print(String message) {
        zoo.print(message);
    }
}