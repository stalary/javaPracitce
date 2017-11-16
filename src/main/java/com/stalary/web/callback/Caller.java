/**
 * @(#)CallBack.java, 2017-11-15.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.web.callback;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CallBack
 *
 * @author lirongqian
 * @since 2017/11/15
 */
@Data
@NoArgsConstructor
public class Caller {

    private MyCallInterface callInterface;

    public void call() {
        callInterface.printName();
    }

}