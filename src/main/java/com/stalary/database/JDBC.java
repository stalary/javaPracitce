package com.stalary.database;

import java.sql.*;

public class JDBC {

    public static void main(String[] args) {
        // 放到try外面，方便在finally(一定会执行)中进行关闭
        Connection conn = null;
        Statement stat = null;
        ResultSet result = null;
        try {
            // 获取驱动
//            Class.forName("com.mysql.jdbc.Driver");
            // 自定义部分
            String url = "jdbc:mysql://localhost:3306/TESTDB?useUnicode=true&characterEncoding=utf-8&useSSL=false";
            String username = "root";
            String password = "li197910";
            // 连接数据库
            conn = DriverManager.getConnection(url, username, password);
            // 创建sql执行对象
            stat = conn.createStatement();
            /*//创建数据库hello
            stat.executeUpdate("create database hello");
            //创建表test
            stat.executeUpdate("create table test(id int, name varchar(30))");
            //添加数据
            stat.executeUpdate("insert into test values(1, 'stalary')");
            stat.executeUpdate("insert into test values(2, 'zyw')");*/

            // 执行sql语句，返回结果集
            result = stat.executeQuery("select * from test");
            // 当结果集存在数据时，进行遍历，类似于迭代器原理
            while (result.next()) {
                // 按字段名获取数据
                int id = result.getInt("id");
                String name = result.getString("name");
                System.out.println("id: " + id + " name: " + name);
            }
        } catch (Exception e) {
            // 在获取驱动和连接数据库，以及执行sql时都有可能发生异常
            e.printStackTrace();
        } finally {
            // 关闭数据库连接等，不关闭会一直保存在内存中，产生内存溢出，需要再非空时才能关闭
            try {
                if (result != null) {
                    result.close();
                }
                if (stat != null) {
                    stat.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}


