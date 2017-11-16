/**
 * @(#)Querybuilder.java, 2017-11-15.
 * <p>
 * Copyright 2017 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.web.cassandra;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.querybuilder.BuiltStatement;
import com.datastax.driver.core.querybuilder.QueryBuilder;

import javax.annotation.Resource;
import java.util.Iterator;


/**
 * Querybuilder
 *
 * @author lirongqian
 * @since 2017/11/15
 */
public class Querybuilder {

    @Resource
    private ICassandraClient client;

    public Student getStudentByKeys(int id, String address) {
        Student student = null;
        BuiltStatement statement = QueryBuilder.select().all().from("devjavasource.user")
                .where(QueryBuilder.eq("userId", id))
                .and(QueryBuilder.eq("address", address));

        ResultSet resultSet = client.execute(statement);
        Iterator<Row> iterator = resultSet.iterator();
        if(iterator.hasNext()) {
            Row row = iterator.next();
            student = new Student();
            student.setAddress(row.getString("address"));
            student.setId(row.getInt(id));
            student.setName(row.getString("name"));
        }
        return student;
    }
}