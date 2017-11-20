/**
 * @(#)CDPlayConfig.java, 2017-11-20.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.web.spring.soundsystem;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * CDPlayConfig
 *
 * @author lirongqian
 * @since 2017/11/20
 */
@Configuration
@ComponentScan(basePackageClasses = {CDPlayer.class})
public class CDPlayConfig {

}