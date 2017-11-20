/**
 * @(#)SgetPeppers.java, 2017-11-20.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.web.spring.soundsystem;

import org.springframework.stereotype.Component;

/**
 * SgetPeppers
 *
 * @author lirongqian
 * @since 2017/11/20
 */
@Component
public class SgetPeppers implements CompactDisc {

    @Override
    public void play() {
        System.out.println("test Component");
    }
}