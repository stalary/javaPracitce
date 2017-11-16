/**
 * @(#)Test.java, 2017-11-15.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.web.cassandra;


import com.datastax.driver.core.querybuilder.QueryBuilder;

import javax.annotation.Resource;

/**
 * Test
 *
 * @author lirongqian
 * @since 2017/11/15
 */
public class Test {

    @Resource
    private Querybuilder querybuilder;

    public void get() {
        System.out.println(querybuilder.getStudentByKeys(1, "stalary"));
    }

}