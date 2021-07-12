package com.doit.utils;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionManager {

    private static ThreadLocal<Connection> t = new ThreadLocal<>();

    public static Connection getConnection() throws  SQLException {

        Connection con = t.get();
        //如果con的值为null 说明第一次获取连接
        if(con == null){
            //从连接池中获取连接
            con = C3P0Utils.getConnection();

            //将连接存储到容器中 然后 返回连接对象
            t.set(con);
        }

        return con;
    }


    //开启事务
    public static void begin(){
        try {
            getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //提交事务
    public static void commit(){
        try {
            getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //回滚
    public static void rollback(){
        try {
            getConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void close(){
        try {
            getConnection().close();
            t.remove();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
