/**
 * @(#)Factory.java, 2018-09-02.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.factory.abstact;

/**
 * Factory
 *
 * @author lirongqian
 * @since 2018/09/02
 */
public interface Factory {
    IOS createIOS();

    Android createAndroid();
}