package com.doit.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
     javax.sql.DataSource  连接池接口
           方法
              Connection getConnection()
              只要使用连接池对象 调用getConnection方法 就是从连接池中 获取了连接对象
              要想获取连接 必须找到DataSource接口的实现类对象  C3P0实现类这个接口
              对应的实现类是ComboPooledDataSource ,我们只要创建这个类的对象
              调用getConnection方法 就 从连接池中 获取到了连接对象



 */
public class C3P0Utils {

    private static ComboPooledDataSource ds ;

    static{

        try{
             ds = new ComboPooledDataSource();
            //配置连接池的信息
//            ds.setDriverClass("com.mysql.jdbc.Driver");
//            ds.setJdbcUrl("jdbc:mysql://localhost:3306/day04");
//            ds.setUser("root");
//            ds.setPassword("root");

            //配合可选项
            //连接池中 默认的连接数
//            ds.setInitialPoolSize(10);
//            ds.setMaxPoolSize(100);
//            ds.setCheckoutTimeout(2000);
//            ds.setMaxIdleTime(60);

        }catch (Exception e){
            throw new RuntimeException(e);
        }


    }

    public static Connection getConnection() throws SQLException {

        Connection con = ds.getConnection();

        return con;

    }


    public static void close(Connection con, Statement stat, ResultSet rs) {
        try {
            if (con != null)
                con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (stat != null)
                stat.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
