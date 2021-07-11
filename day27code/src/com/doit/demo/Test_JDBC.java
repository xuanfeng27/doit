package com.doit.demo;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
     注册驱动
         告知JVM使用的是哪个数据库驱动
     获取连接
         获取与数据库连接的对象
     获取执行sql语句对象
        通过连接对象 获取到一个用来执行sql语句的对象

     执行sql语句
         通过执行sql语句的对象 来执行sql语句
     处理结果
         对于增删改sql语句执行后 返回的结果是影响的行数
         一般不需要处理
         对于查询sql语句执行后 会返回结果集对象
         需要把数据从结果集对象中获取出来

     关闭资源
         关闭连接
 */
public class Test_JDBC {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        /*
             1.注册驱动
                java.sql.DriverManager
                     静态方法
                        static void registerDriver(Driver driver)
                        方法的参数是java.sql.Driver是接口 只能传入其实现类对象
                        mysql驱动实现了这个接口  com.mysql.jdbc.Driver

         */
        //注册了两次驱动 没有必要
        //DriverManager.registerDriver(new Driver());
       // 不好 硬编码 写死了
       // new Driver();
        Class.forName("com.mysql.jdbc.Driver");

        /*
            2.获取连接
                java.sql.DriverManager
                    静态方法
                        static Connection getConnection(String url, String user, String password)
                        通过url 和用户名 密码获取到连接对象

                        jdbc:mysql://ip地址:3306/要连接数据库的名字
         */

        String url = "jdbc:mysql://127.0.0.1:3306/day03";
        String username = "root";
        String password = "root";
        Connection con = DriverManager.getConnection(url, username, password);
//        System.out.println(con);

        /*
             获取执行sql语句对象
                java.sql.Connection 接口
                     方法
                         Statement createStatement()    创建一个 Statement 对象来将 SQL 语句发送到数据库。

         */
        Statement stat = con.createStatement();
        /*
            执行sql语句
                java.sql.Statement
                   方法
                        int executeUpdate(String sql) 执行增删改 sql语句   返回值int类型 返回影响的行数


         */
        String sql = "delete from user where id = 2";
        int row = stat.executeUpdate(sql);
        System.out.println(row);



        stat.close();
        con.close();
    }
}
