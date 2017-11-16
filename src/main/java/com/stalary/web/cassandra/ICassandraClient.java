/**
 * @(#)ICassandraClient.java, 2017/02/15.
 * Copyright (c) 2016 Yodao, Inc. All rights reserved.
 * YODAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.web.cassandra;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.ResultSetFuture;
import com.datastax.driver.core.Statement;

/**
 * ICassandraClient
 *
 * @author zhumeng
 * @since 2017/02/15
 */
public interface ICassandraClient {

    ResultSet execute(String query);

    ResultSet execute(Statement statement);

    ResultSetFuture executeAsync(Statement statement);

}