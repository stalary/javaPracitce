/**
 * @(#)Warn.java, 2018-09-11.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.template;

/**
 * Warn
 *
 * @author lirongqian
 * @since 2018/09/11
 */
public class Warn extends Note {
    @Override
    public String content() {
        return "您的账号在济南登陆";
    }
}