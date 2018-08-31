/**
 * @(#)Main.java, 2018-08-30.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.strategy;

/**
 * Main
 *
 * @author lirongqian
 * @since 2018/08/30
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("go to zoo to see animal");
        System.out.println("to see elephant");
        StrategyManager manager = new StrategyManager(new ElephantStrategy());
        manager.execute();
        System.out.println("to see bird");
        manager.changeStrategy(new BirdStrategy());
        manager.execute();
        System.out.println("to see monkey");
        manager.changeStrategy(new MonkeyStrategy());
        manager.execute();
    }
}