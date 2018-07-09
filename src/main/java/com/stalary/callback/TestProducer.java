/**
 * @(#)TestProducer.java, 2018-07-09.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.callback;

/**
 * TestProducer
 *
 * @author lirongqian
 * @since 2018/07/09
 */
public class TestProducer implements Producer {
    @Override
    public void send(String str, Callback callback) {
        callback.print(str);
    }
}