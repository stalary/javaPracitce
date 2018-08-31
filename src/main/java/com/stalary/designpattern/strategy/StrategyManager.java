/**
 * @(#)StrategyManager.java, 2018-08-30.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.strategy;

/**
 * StrategyManager
 *
 * @author lirongqian
 * @since 2018/08/30
 */
public class StrategyManager {

    /** 策略方法 **/
    private ZooStrategy strategy;

    public StrategyManager(ZooStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 更换策略
     * @param strategy
     */
    public void changeStrategy(ZooStrategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        strategy.execute();
    }
}