/**
 * @(#)User.java, 2018-09-05.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.adapter;

/**
 * User
 *
 * @author lirongqian
 * @since 2018/09/05
 */
public class User {

    private ThreePinPlug plug;

    public User(ThreePinPlug plug) {
        this.plug = plug;
    }

    public void setPlug(ThreePinPlug plug) {
        this.plug = plug;
    }

    public void charge() {
        plug.charge();
    }
}