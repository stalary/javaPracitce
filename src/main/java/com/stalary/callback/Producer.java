/**
 * @(#)Producer.java, 2018-07-09.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.callback;

/**
 * Producer
 *
 * @author lirongqian
 * @since 2018/07/09
 */
public interface Producer {

    void send(String str, Callback callback);
}