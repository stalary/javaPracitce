/**
 * @(#)Origin.java, 2018-09-06.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.bridge;

/**
 * Origin
 *
 * @author lirongqian
 * @since 2018/09/06
 */
public class Origin implements Area {

    private Bridge bridge;

    public Origin(Bridge bridge) {
        this.bridge = bridge;
    }

    @Override
    public void fromArea() {
        System.out.println("从原地点出发");
        bridge.goTarget();
    }
}