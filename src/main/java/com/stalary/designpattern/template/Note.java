/**
 * @(#)Note.java, 2018-09-11.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.template;

/**
 * Note
 *
 * @author lirongqian
 * @since 2018/09/11
 */
public abstract class Note {
    public abstract String content();

    public void send(String receiver) {
        System.out.println("尊敬的" + receiver);
        System.out.println(content());
    }
}