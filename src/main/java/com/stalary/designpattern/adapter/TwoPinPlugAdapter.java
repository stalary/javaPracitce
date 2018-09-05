/**
 * @(#)WildAnimalAdapter.java, 2018-09-05.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.adapter;

/**
 * TwoPinPlugAdapter
 *
 * @author lirongqian
 * @since 2018/09/05
 */
public class TwoPinPlugAdapter implements ThreePinPlug {

    private TwoPinPlug plug;

    public TwoPinPlugAdapter() {
        this.plug = new TwoPinPlug();
    }

    @Override
    public void charge() {
        plug.charge();
    }
}