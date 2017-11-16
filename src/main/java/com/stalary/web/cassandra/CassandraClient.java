/**
 * @(#)CassandraClient.java, 2017-11-15.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.web.cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

/**
 * CassandraClient
 *
 * @author lirongqian
 * @since 2017/11/15
 */
public class CassandraClient {

    public void connect() {
        Cluster cluster = null;

        try {
            // 创建连接
            cluster = Cluster.builder()
                    .addContactPoint("127.0.0.1")
                    .build();
            // 创建用户会话
            Session session = cluster.connect();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}