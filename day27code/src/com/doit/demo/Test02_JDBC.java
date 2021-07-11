package com.doit.demo;

import java.sql.*;

public class Test02_JDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");


        String url = "jdbc:mysql://127.0.0.1:3306/day03";
        String username = "root";
        String password = "root";
        Connection con = DriverManager.getConnection(url, username, password);


        Statement stat = con.createStatement();


        /*  Statement
                方法
                     ResultSet executeQuery(String sql)执行查询的sql语句
                     返回值是一个结果集 可以理解为是一个集合

         */
        ResultSet rs = stat.executeQuery("select * from user");

        /*  ResultSet
            处理结果集
                 boolean next()
                        将光标从当前位置向前移一行。

                 getObject(String 列名)

                 getInt(String 列名)
                 getString(String 列名)
         */

        while(rs.next()){
            int id = rs.getInt("id");
            String user = rs.getString("username");
            String pass = rs.getString("password");

            System.out.println(id+" "+user+" "+pass);
        }



        rs.close();
        stat.close();
        con.close();
    }
}
