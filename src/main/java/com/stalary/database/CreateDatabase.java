package com.stalary.database;

import java.sql.*;

/**
 * @Author:Stalary
 * @Description:
 * @Date Created in 2017/9/29
 */
public class CreateDatabase {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        //一开始必须填一个已经存在的数据库
        String url = "jdbc:mysql://localhost:3306/TESTDB?useUnicode=true&characterEncoding=utf-8";
        Connection conn = DriverManager.getConnection(url, "root", "li197910");
        Statement stat = conn.createStatement();

        //创建数据库hello
        stat.executeUpdate("create database hello");

        //打开创建的数据库
        stat.close();
        conn.close();
        url = "jdbc:mysql://localhost:3306/hello?characterEncoding=utf-8";
        conn = DriverManager.getConnection(url, "root", "li197910");
        stat = conn.createStatement();

        //创建表test
        stat.executeUpdate("create table test(id int, name varchar(30))");

        //添加数据
        stat.executeUpdate("insert into test values(1, 'stalary')");
        stat.executeUpdate("insert into test values(2, 'zyw')");

        //查询数据
        ResultSet result = stat.executeQuery("select * from test");
        while (result.next())
        {
            System.out.println(result.getInt("id") + " " + result.getString("name"));
        }

        //关闭数据库
        result.close();
        stat.close();
        conn.close();
    }


}


