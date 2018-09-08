/**
 * @(#)Main.java, 2018-09-06.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.bridge;

/**
 * Main
 *
 * @author lirongqian
 * @since 2018/09/06
 */
public class Main {

    public static void main(String[] args) {
        Area area = new Origin(new Target());
        area.fromArea();
    }
}